package com.sgut.android.nationalfootballleague.teamdetails

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.Athletes
import com.sgut.android.nationalfootballleague.NextEvent3
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

    val nextEvents: MutableState<List<NextEvent3?>> = mutableStateOf(listOf())


    var toastMessageObserver: MutableState<String?> = mutableStateOf(null)

    init {

//        loadTeamDetails()

    }


        //team abrv here
    fun loadTeamDetails(teamAbv: String) = viewModelScope.launch {
        try {
            val result = espnRepository.getSpecificNflTeam(teamAbv)
            team.value = result
            atheletes.value = result.athletes
            nextEvents.value = result.nextEvent

            Log.i("DEBUG", result.toString())

        } catch (e: Exception){
            Log.i("DEBUG",e.message.toString())
            toastMessageObserver?.value =  e.toString()

        }
    }

    fun loadTeamDetails2(teamAbv: String, sport:String, league: String) = viewModelScope.launch {
        try {
            val result = espnRepository.getSpecificTeam(sport, league, teamAbv)
            team.value = result
            atheletes.value = result.athletes
            nextEvents.value = result.nextEvent

            Log.i("DEBUG-TEAM DETAIL", result.toString())

        } catch (e: Exception){
            Log.i("DEBUG-TEAM DETAIL",e.message.toString())
        }
    }




}
object HexToJetpackColor {
    fun getColor(colorString: String): Color {
        return Color(android.graphics.Color.parseColor("#" + colorString))
    }
}