package com.sgut.android.nationalfootballleague.ui.screens.scoreboardscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.domain.domainmodels.ArticleModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardModel
import com.sgut.android.nationalfootballleague.domain.repositories.EspnRepository
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
    private val espnRepository: EspnRepository,
    private val scoreboardRepository: ScoreboardRepository
): ViewModel() {

    private val _scoreboardUiState = MutableStateFlow(ScoreboardUiState())
    var scoreboardUiState: StateFlow<ScoreboardUiState> = _scoreboardUiState.asStateFlow()

    var newScoreboardModelState: StateFlow<ScoreboardUiState> = _scoreboardUiState.asStateFlow()

    init {}


    fun loadGenericScoreboard(sport: String, league: String) = viewModelScope.launch {
        try{

            if(league.equals(NCAA_BASKETBALL)) {
                val articlesListResult = espnRepository.getArticles(sport, league)
                val currentScoreboardModelUiState = scoreboardRepository.getCollegeBasketballScoreboard(sport, league, "200")
                setScoreboardUiState( sport, league, articlesListResult, currentScoreboardModelUiState )
            } else {
                val articlesListResult = espnRepository.getArticles(sport, league)
                val currentScoreboardModelUiState = scoreboardRepository.getGeneralScoreboard(sport, league)
                Log.e("NEWSCORBOARDUiSate-SUCC", currentScoreboardModelUiState.toString())
                setScoreboardUiState( sport, league, articlesListResult, currentScoreboardModelUiState )
            }
        } catch (e: Exception) {
            Log.i("DEBUG-rc vm",e.stackTraceToString())
        }
    }



    fun setScoreboardUiState(
        currentSport: String,
        currentLeague: String,
        currentArticles: List<ArticleModel>,
        currentScoreboardModelUiState: ScoreboardModel
    ) {
        _scoreboardUiState.update {
            it.copy(
                currentSport = currentSport,
                currentLeague = currentLeague,
                currentArticles = currentArticles,
                scoreboardModelUiState = currentScoreboardModelUiState
            )
        }
    }

}