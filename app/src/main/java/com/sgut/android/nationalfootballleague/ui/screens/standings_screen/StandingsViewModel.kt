package com.sgut.android.nationalfootballleague.ui.screens.standings_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models.StandingsModel
import com.sgut.android.nationalfootballleague.domain.repositories.StandingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val standingsRepository: StandingsRepository,
): ViewModel() {
    private val _standingsUiState = MutableStateFlow(StandingsUiState())
    var standings: StateFlow<StandingsUiState> = _standingsUiState.asStateFlow()
    var standingsState: StateFlow<StandingsUiState> = _standingsUiState.asStateFlow()

    init {
        crazyLog(n = 15)
    }

    fun crazyLog(n: Int): List<String>{
        val list = mutableListOf<String>()
        for (i in 1..n) {

           if (i % 3 == 0) {
               list.add("$i - Fizz")

           }
            if(i % 5 == 0){
                list.add("$i - Buzz")
            }
            if(i % 5 == 0 && i % 3 == 0){
                list.add("$i - FizBuzz")
            }
           else {
               list.add(i.toString())
           }
        }
        Log.e("CRZY LOG", list.toString() )
        return list
    }

    fun loadStandings(sport: String, league: String, type: String) = viewModelScope.launch {
        try {
            val currentStandingsUiState = standingsRepository.getStandings(sport, league, type)
            setStandingsUiState(sport, league, currentStandingsUiState)
        } catch (e :Exception){
            Log.i("DEBUG-Stndg vm", e.stackTraceToString())

        }

    }

    fun setStandingsUiState(
        currentSport: String,
        currentLeague: String,
        currentStandingsModelUiState: StandingsModel,
        ) {
        _standingsUiState.update {
            it.copy(
                currentSport = currentSport,
                currentLeague = currentLeague,
                standingsUiState = currentStandingsModelUiState
            )
        }
    }

}