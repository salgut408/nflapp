package com.sgut.android.nationalfootballleague.homelistscreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDomainModel
import com.sgut.android.nationalfootballleague.domain.ListUiState
import com.sgut.android.nationalfootballleague.repository.EspnRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeListViewModel @Inject constructor(
    private val espnRepository: EspnRepository
) : ViewModel() {

    private val _ListUiState = MutableStateFlow(ListUiState())
    val listUiState: StateFlow<ListUiState> = _ListUiState.asStateFlow()


    var allLists = mutableStateOf<List<TeamDomainModel>>(listOf())

     var nflTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
     var collegeTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
     var baseballTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
     var hockeyTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
     var basketballTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
     var soccerTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
     var womensBasketballTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())






    init {
        loadAllNflTeams()
        loadAllCollegeTeams()
        loadAllBaseballTeams()
        loadAllBasketballTeams()
        loadAllSoccerTeams()
        loadAllWomensBasketballTeams()
        loadAllHockeyTeams()

//        when(_ListUiState) {
//
//        }

    }

    fun loadAllBaseballTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getAllBaseballTeams()
            baseballTeamsList.value = result
            Log.i("tag", result.toString())
        } catch (e: Exception) {
            Log.i("tag",e.message.toString())
        }
    }

    fun loadAllNflTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getTeams()
            nflTeamsList.value = result
            _ListUiState.update { currentState ->
            currentState.copy(currentTeam = result, currentSport = "football", currentLeague = "nfl")
        }
            Log.i("tag", result.toString())
        } catch (e: Exception) {
            Log.i("tag",e.message.toString())
        }
    }

    fun loadAllCollegeTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getAllCollegeTeams()
            collegeTeamsList.value = result
            Log.i("tag", result.toString())

        } catch (e: Exception) {
            Log.i("tag",e.message.toString())

        }
    }

    fun loadAllHockeyTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getAllHockeyTeams()
            hockeyTeamsList.value = result
            Log.i("tag", result.toString())

        } catch (e: Exception) {
            Log.i("tag",e.message.toString())

        }
    }

    fun loadAllBasketballTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getAllBasketballTeams()
            basketballTeamsList.value = result
            Log.i("tag", result.toString())

        } catch (e: Exception) {
            Log.i("tag",e.message.toString())

        }
    }

    fun loadAllSoccerTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getAllSoccerTeams()
            soccerTeamsList.value = result
            Log.i("tag", result.toString())

        } catch (e: Exception) {
            Log.i("tag",e.message.toString())

        }
    }

    fun loadAllWomensBasketballTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getAllWomensBasketballTeams()
            womensBasketballTeamsList.value = result
            Log.i("tag", result.toString())

        } catch (e: Exception) {
            Log.i("tag",e.message.toString())

        }
    }

    fun setBaseballTeam() {
       _ListUiState.update {
           it.copy(currentTeam = baseballTeamsList.value, currentSport = "baseball", currentLeague = "mlb")
       }
    }

    fun setBasketballTeam() {
        _ListUiState.update {
            it.copy(currentTeam = basketballTeamsList.value, currentSport = "basketball", currentLeague = "nba")
        }
    }

    fun setFootballTeam() {
        _ListUiState.update {
            it.copy(currentTeam = nflTeamsList.value, currentSport = "football", currentLeague = "nfl")
        }
    }



    fun setHockeyTeam() {
//        loadAllHockeyTeams()
        _ListUiState.update {
            it.copy(currentTeam = hockeyTeamsList.value, currentSport = "hockey", currentLeague = "nhl")
        }
    }



}