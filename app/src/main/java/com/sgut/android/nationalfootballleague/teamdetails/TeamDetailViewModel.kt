package com.sgut.android.nationalfootballleague.teamdetails

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailModel
import com.sgut.android.nationalfootballleague.repository.EspnRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@HiltViewModel
class TeamDetailViewModel @Inject constructor(
    private val espnRepository: EspnRepository
): ViewModel() {

    val team: MutableState<TeamDetailModel?> = mutableStateOf(null)

    init {

        loadTeamDetails()
    }



    fun loadTeamDetails() = viewModelScope.launch {
        try {
            val result = espnRepository.getSpecificNflTeam()
            team.value = result
            Log.i("tag", result.toString())

        } catch (e: Exception){
            Log.i("tag",e.message.toString())

        }
    }


}