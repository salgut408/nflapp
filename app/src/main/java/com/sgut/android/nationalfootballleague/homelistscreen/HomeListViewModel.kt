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

    var nflTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
    var collegeTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
    var baseballTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())

    init {
        loadAllNflTeams()
        loadAllCollegeTeams()
        loadAllBaseballTeams()
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

}