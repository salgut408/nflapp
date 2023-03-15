package com.sgut.android.nationalfootballleague.ui.screens.scoreboardscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.domain.domainmodels.ArticleModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.ScoreboardResponseEventModel
import com.sgut.android.nationalfootballleague.domain.repositories.EspnRepository
import com.sgut.android.nationalfootballleague.domain.repositories.ScoreboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class ScoreboardViewModel @Inject constructor(
    private val espnRepository: EspnRepository,
    private val scoreboardRepository: ScoreboardRepository
): ViewModel() {

    private val _scoreboardUiState = MutableStateFlow(ScoreboardUiState())
    var scoreboardUiState: StateFlow<ScoreboardUiState> = _scoreboardUiState.asStateFlow()

    var currentDate: Int
    var week: Int = 0

    init {
        currentDate = getYesterdaysDate()
        week = _scoreboardUiState.value.scoreboardUiStateEvents.week.week
        tryNewState()
    }

    fun tryNewState() = viewModelScope.launch {
        try{
            val new = scoreboardRepository.getGeneralScoreboard("basketball", "nba")
            Log.e("NEWSCORBOARD-SUCC", new.toString())
        } catch (e: Exception) {
            Log.e("NEWSCORBOARD-FAIL", e.stackTraceToString())
        }
    }

    fun loadGenericScoreboard(sport: String, league: String) = viewModelScope.launch {
        try{
            val result = espnRepository.getGeneralScoreboardResponse(sport, league)
            val articlesListResult = espnRepository.getArticles(sport, league)
            setScoreboardUiState(result, sport, league, articlesListResult)

        } catch (e: Exception) {
            Log.i("DEBUG-rc vm",e.message.toString())
        }
    }



    fun setScoreboardUiState(scoreboardUiStateEvents  : ScoreboardResponseEventModel, currentSport: String, currentLeague: String, currentArticles: List<ArticleModel>,  ) {
        _scoreboardUiState.update {
            it.copy(
                scoreboardUiStateEvents = scoreboardUiStateEvents,
                currentSport = currentSport,
                currentLeague = currentLeague,
                currentArticles = currentArticles,
            )
        }
    }


    fun getYesterdaysDate(): Int {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
        val formatted = current.format(formatter).toInt()
        return formatted - 1
    }
}