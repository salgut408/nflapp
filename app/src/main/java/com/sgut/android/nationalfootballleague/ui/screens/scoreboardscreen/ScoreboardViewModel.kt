package com.sgut.android.nationalfootballleague.ui.screens.scoreboardscreen

import android.icu.util.Calendar
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticleDomianModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardModel
import com.sgut.android.nationalfootballleague.domain.repositories.ScoreboardRepository
import com.sgut.android.nationalfootballleague.domain.use_cases.GetArticlesUseCase
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NCAA_BASKETBALL
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
    private val getArticles: GetArticlesUseCase
) : ViewModel() {

    private val _scoreboardUiState = MutableStateFlow(ScoreboardUiState())
    var scoreboardUiState: StateFlow<ScoreboardUiState> = _scoreboardUiState.asStateFlow()

    var newScoreboardModelState: StateFlow<ScoreboardUiState> = _scoreboardUiState.asStateFlow()


    init {
    }

//    fun getCompetitionHomeTeam(): ScoreboardCompetitorsModel {
//        return scoreboardUiState.value.scoreboardModelUiState.events.
//    }


    fun loadGenericScoreboard(sport: String, league: String) = viewModelScope.launch {
        try {

            if (league.equals(NCAA_BASKETBALL)) {

                val articlesListResult = getArticles(sport, league)

                val currentScoreboardModelUiState = scoreboardRepository.getCollegeBasketballScoreboard(sport, league, "200")

                setScoreboardUiState(
                    sport, league,
                    currentScoreboardModelUiState, articlesListResult,
                )
            } else {

                val articlesListResult = getArticles(sport, league)

                val currentScoreboardModelUiState =
                    scoreboardRepository.getGeneralScoreboard(sport, league)
                setScoreboardUiState(
                    sport, league,
                    currentScoreboardModelUiState, articlesListResult)
            }
        } catch (e: Exception) {
            Log.i("DEBUG-rc vm", e.stackTraceToString())
        }
    }


    fun getTodaysDate(): String {
        val date = Calendar.getInstance()
        val year = date.get(Calendar.YEAR).toString()
        val month = (date.get(Calendar.MONTH) + 1).toString()
        val day = date.get(Calendar.DAY_OF_MONTH).toString()
        return year + month + day
    }

    fun setScoreboardUiState(
        currentSport: String,
        currentLeague: String,
        currentScoreboardModelUiState: ScoreboardModel,
        currentArticles: List<ArticleDomianModel>,
    ) {
        _scoreboardUiState.update {
            it.copy(
                currentSport = currentSport,
                currentLeague = currentLeague,
                scoreboardModelUiState = currentScoreboardModelUiState,
                currentArticles = currentArticles
            )
        }
    }

}