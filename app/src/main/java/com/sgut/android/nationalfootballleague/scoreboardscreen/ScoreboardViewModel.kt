package com.sgut.android.nationalfootballleague.scoreboardscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.data.domainmodels.ArticleModel
import com.sgut.android.nationalfootballleague.data.domainmodels.ScoreboardResponseEventModel
import com.sgut.android.nationalfootballleague.data.repository.EspnRepositoryImpl
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
    private val espnRepository: EspnRepositoryImpl
): ViewModel() {

    private val _scoreboardUiState = MutableStateFlow(ScoreboardUiState())
    var scoreboardUiState: StateFlow<ScoreboardUiState> = _scoreboardUiState.asStateFlow()

    private var competitionMap = _scoreboardUiState.value.scoreboardUiStateEvents.events.associateBy ({it.competitions}, {it.status})

    var currentDate: Int
    var week: Int = 0

    init {
        currentDate = getYesterdaysDate()
        week = _scoreboardUiState.value.scoreboardUiStateEvents.week.week
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

    fun onYesterdayClick(sport: String, league: String, week: Int) = viewModelScope.launch {

       val lastWeek = week -1
        try{
            val result = espnRepository.getYesterdayGeneralScoreboardResponse(sport, league, lastWeek)
            val articlesListResult = espnRepository.getArticles(sport, league)
            setScoreboardUiState(result, sport, league, articlesListResult, )
            Log.i("Load_YESTERDAY", result.events.toString())
            Log.d("HASHMAP", competitionMap.toString())


        } catch (e: Exception) {
            Log.i("DEBUG-rc vm",e.message.toString())
        }
    }

    fun setScoreboardUiState(scoreboardUiStateEvents  : ScoreboardResponseEventModel, currentSport: String, currentLeague: String, currentArticles: List<ArticleModel>,  ) {
        _scoreboardUiState.update {
            it.copy(scoreboardUiStateEvents = scoreboardUiStateEvents, currentSport = currentSport, currentLeague = currentLeague, currentArticles = currentArticles,  )
        }
    }


    fun getYesterdaysDate(): Int {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
        val formatted = current.format(formatter).toInt()
        return formatted - 1


    }

}