package com.sgut.android.nationalfootballleague.scoreboardscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.data.domainmodels.ArticleModel
import com.sgut.android.nationalfootballleague.data.domainmodels.ScoreboardResponseEventModel
import com.sgut.android.nationalfootballleague.data.repository.EspnRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScoreboardViewModel @Inject constructor(
    private val espnRepository: EspnRepository
): ViewModel() {

    private val _scoreboardUiState = MutableStateFlow(ScoreboardUiState())
    val scoreboardUiState: StateFlow<ScoreboardUiState> = _scoreboardUiState.asStateFlow()




    init {
//        loadScoreboard()
    }


    fun loadGenericScoreboard(sport: String, league: String) = viewModelScope.launch {
        try{
            val result = espnRepository.getGeneralScoreboardResponse(sport, league)
            val articlesListResult = espnRepository.getArticles(sport, league)
            setScoreboardUiState(result, sport, league, articlesListResult)
            Log.i("DEBUG-scoreboard vm", articlesListResult.toString())

        } catch (e: Exception) {
            Log.i("DEBUG-scoreboard vm",e.message.toString())
        }
    }

    fun setScoreboardUiState(scoreboardUiStateEvents  : ScoreboardResponseEventModel, currentSport: String, currentLeague: String, currentArticles: List<ArticleModel>) {
        _scoreboardUiState.update {
            it.copy(scoreboardUiStateEvents = scoreboardUiStateEvents, currentSport = currentSport, currentLeague = currentLeague, currentArticles = currentArticles )
        }
    }

}