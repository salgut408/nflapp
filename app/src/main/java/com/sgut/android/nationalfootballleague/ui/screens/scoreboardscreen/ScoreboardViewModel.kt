package com.sgut.android.nationalfootballleague.ui.screens.scoreboardscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard.BaseballScoreBoardNetwork
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticlesListModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.DefaultScoreboardModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.TennisScoreboardModel
import com.sgut.android.nationalfootballleague.domain.repositories.ScoreboardRepository
import com.sgut.android.nationalfootballleague.domain.use_cases.GetArticlesUseCase
import com.sgut.android.nationalfootballleague.domain.use_cases.GetBaseballSituationUseCase
import com.sgut.android.nationalfootballleague.domain.use_cases.GetScoresUseCase
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.ATP
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.TENNIS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScoreboardViewModel @Inject constructor(
    private val scoreboardRepository: ScoreboardRepository,
    private val getArticles: GetArticlesUseCase,
    private val getScores: GetScoresUseCase,
    private val getBaseballSituationUseCase: GetBaseballSituationUseCase
) : ViewModel() {

    private val _scoreboardUiState = MutableStateFlow(ScoreboardUiState())

    var scoreboardModelState: StateFlow<ScoreboardUiState> = _scoreboardUiState.asStateFlow()

    private val _baseballScoreboard = MutableStateFlow(BaseballScoreBoardNetwork())
    var baseballScoreboard: StateFlow<BaseballScoreBoardNetwork> = _baseballScoreboard.asStateFlow()

    private var _tennis = MutableStateFlow(TennisScoreboardModel())
    var tennis: StateFlow<TennisScoreboardModel> =_tennis


    init {

    }

//    fun loadBaseballScoreboard(sport: String, league: String) = viewModelScope.launch {
//        val baseballScoreboard = scoreboardRepository.getBaseballScoreboard(sport, league )
//        _baseballScoreboard.emit(baseballScoreboard).printToLog("BBAL")
//    }

    fun loadGenericScoreboard(sport: String, league: String) = viewModelScope.launch {
        try {

            _tennis.emit(scoreboardRepository.getTennisScoreBoard(TENNIS, ATP))
//            tennis.printToLog("TENNIS_VM")

                val news = getArticles(sport, league)
                val currentScoreboardModelUiState = getScores(sport, league)
//            loadBaseballScoreboard(sport, league)

                setScoreboardUiState(
                    sport, league,
                    currentScoreboardModelUiState,
                    news
                )
        } catch (e: Exception) {
            Log.i("DEBUG-rc vm", e.stackTraceToString())
        }
    }



    fun setScoreboardUiState(
        currentSport: String,
        currentLeague: String,
        currentDefaultScoreboardModelUiState: DefaultScoreboardModel,
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