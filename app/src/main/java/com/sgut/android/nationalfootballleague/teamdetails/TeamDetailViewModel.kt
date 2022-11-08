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

    val primaryColor: MutableState<String?> = mutableStateOf(null)
    val alternateColor: MutableState<String?> = mutableStateOf(null)


    var toastMessageObserver: MutableState<String?> = mutableStateOf(null)

    init {

        loadTeamDetails()

    }


        //team abrv here
    fun loadTeamDetails() = viewModelScope.launch {
        try {
            val result = espnRepository.getSpecificNflTeam("lac")
            team.value = result
            atheletes.value = result.athletes
            nextEvents.value = result.nextEvent
            primaryColor.value = HexToJetpackColor.getColor(result.color!!).toString()
            alternateColor.value = HexToJetpackColor.getColor(result.alternateColor!!).toString()
            Log.i("DEBUG", result.toString())

        } catch (e: Exception){
            Log.i("DEBUG",e.message.toString())
            toastMessageObserver?.value =  e.toString()

        }
    }




}
object HexToJetpackColor {
    fun getColor(colorString: String): Color {
        return Color(android.graphics.Color.parseColor("#" + colorString))
    }
}