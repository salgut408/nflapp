package com.sgut.android.nationalfootballleague.ui.screens.scoreboardscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticleDomianModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardModel
import com.sgut.android.nationalfootballleague.domain.repositories.ArticleRepository
import com.sgut.android.nationalfootballleague.domain.repositories.ScoreboardRepository
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
    private val articleRepository: ArticleRepository,
) : ViewModel() {

    private val _scoreboardUiState = MutableStateFlow(ScoreboardUiState())
    var scoreboardUiState: StateFlow<ScoreboardUiState> = _scoreboardUiState.asStateFlow()

    var newScoreboardModelState: StateFlow<ScoreboardUiState> = _scoreboardUiState.asStateFlow()

    init {

    }


    fun loadGenericScoreboard(sport: String, league: String) = viewModelScope.launch {
        try {

            if (league.equals(NCAA_BASKETBALL)) {
                val currentScoreboardModelUiState =
                    scoreboardRepository.getCollegeBasketballScoreboard(sport, league, "200")
                val articlesListResult = articleRepository.getArticles(sport, league)
                setScoreboardUiState(
                    sport, league,
                    currentScoreboardModelUiState, articlesListResult,
                )
            } else {
                val articlesListResult = articleRepository.getArticles(sport, league)
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