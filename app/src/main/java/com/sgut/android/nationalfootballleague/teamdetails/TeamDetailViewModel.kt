package com.sgut.android.nationalfootballleague.teamdetails

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.Athletes
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailModel
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailWithRosterModel
import com.sgut.android.nationalfootballleague.repository.EspnRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamDetailViewModel @Inject constructor(
    private val espnRepository: EspnRepository
): ViewModel() {

     val team: MutableState<TeamDetailWithRosterModel?> = mutableStateOf(null)
    val atheletes: MutableState<List<Athletes?>> = mutableStateOf(listOf())


    var toastMessageObserver: MutableState<String?> = mutableStateOf(null)

    init {

        loadTeamDetails()

    }



    fun loadTeamDetails() = viewModelScope.launch {
        try {
            val result = espnRepository.getSpecificNflTeam()
            team.value = result
            atheletes.value = result.athletes
            Log.i("tag", result.toString())

        } catch (e: Exception){
            Log.i("tag",e.message.toString())
            toastMessageObserver?.value =  e.toString()

        }
    }


}