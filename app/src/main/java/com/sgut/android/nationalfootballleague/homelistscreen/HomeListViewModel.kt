package com.sgut.android.nationalfootballleague.homelistscreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDomainModel
import com.sgut.android.nationalfootballleague.repository.EspnRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeListViewModel @Inject constructor(
    private val espnRepository: EspnRepository
) : ViewModel() {

    var allLists = mutableStateOf<List<TeamDomainModel>>(listOf())

     var nflTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
     var collegeTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
     var baseballTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
     var hockeyTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
     var basketballTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
     var soccerTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
     var womensBasketballTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())






    init {
//        loadAllNflTeams()
//        loadAllCollegeTeams()
        loadAllBaseballTeams()
//        loadAllHockeyTeams()
//        loadAllBasketballTeams()
//        loadAllSoccerTeams()
//        loadAllWomensBasketballTeams()
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



}