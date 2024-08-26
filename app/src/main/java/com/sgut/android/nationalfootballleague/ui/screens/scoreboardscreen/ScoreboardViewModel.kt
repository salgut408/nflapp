package com.sgut.android.nationalfootballleague.ui.screens.scoreboardscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard.BaseballScoreBoardNetwork
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticlesListModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.BasicScoreboardModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.TennisScoreboardModel
import com.sgut.android.nationalfootballleague.domain.repositories.ScoreboardRepository
import com.sgut.android.nationalfootballleague.domain.use_cases.GetArticlesUseCase
import com.sgut.android.nationalfootballleague.domain.use_cases.GetBaseballSituationUseCase
import com.sgut.android.nationalfootballleague.domain.use_cases.GetScoresUseCase
import com.sgut.android.nationalfootballleague.domain.use_cases.NewScoresUseCase
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.ATP
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.TENNIS
import com.sgut.android.nationalfootballleague.utils.printToLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ScoreboardViewModel @Inject constructor(
    private val scoreboardRepository: ScoreboardRepository,
    private val getArticles: GetArticlesUseCase,
    private val getScores: GetScoresUseCase,
    private val newScoressCase: NewScoresUseCase,
    private val getBaseballSituationUseCase: GetBaseballSituationUseCase
) : ViewModel() {

    private val _scoreboardUiState = MutableStateFlow(ScoreboardUiState())

    var scoreboardModelState: StateFlow<ScoreboardUiState> = _scoreboardUiState.asStateFlow()

    private val _baseballScoreboard = MutableStateFlow(BaseballScoreBoardNetwork())
    var baseballScoreboard: StateFlow<BaseballScoreBoardNetwork> = _baseballScoreboard.asStateFlow()

    private var _tennis = MutableStateFlow(TennisScoreboardModel())
    var tennis: StateFlow<TennisScoreboardModel> =_tennis

//    private var _ABSTRACTS = MutableStateFlow<ScoreboardData>(DefaultScoreboardData())


    init {

    }

//    fun loadBaseballScoreboard(sport: String, league: String) = viewModelScope.launch {
//        val baseballScoreboard = scoreboardRepository.getBaseballScoreboard(sport, league )
//        _baseballScoreboard.emit(baseballScoreboard).printToLog("BBAL")
//    }

    fun loadGenericScoreboard(sport: String, league: String) = viewModelScope.launch {
        try {

//            _tennis.emit(scoreboardRepository.getTennisScoreBoard(TENNIS, ATP))
            _tennis.emit(scoreboardRepository.getTennisScoreBoard(TENNIS, ATP)) // this is just chekcing

            val news = getArticles(sport, league)
                val currentScoreboardModelUiState = getScores(sport, league)

           val abstractScoresFromRepo = viewModelScope.launch {
                   scoreboardRepository.getAbstractScoreBoard(sport, league)
               }

            Timber.d("abstractScoresFromRepo in vm $abstractScoresFromRepo")

            val newAbstractScores = newScoressCase(sport, league)
            Timber.d("newAbstractScores in vm $newAbstractScores")

                setScoreboardUiState(
                    sport, league,
                    currentScoreboardModelUiState,
                    news
                )
        } catch (e: Exception) {
            Timber.e("ERROR loadGenericScoreboard")
        }
    }



    private fun setScoreboardUiState(
        currentSport: String,
        currentLeague: String,
        currentDefaultScoreboardModelUiState: BasicScoreboardModel,
        currentNews: ArticlesListModel,
    ) {
        _scoreboardUiState.update {
            it.copy(
                currentSport = currentSport,
                currentLeague = currentLeague,
                defaultScoreboardModelUiState = currentDefaultScoreboardModelUiState,
                currentArticles = currentNews
            )
        }
    }

}