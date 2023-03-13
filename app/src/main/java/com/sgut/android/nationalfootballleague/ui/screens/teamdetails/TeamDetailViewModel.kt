package com.sgut.android.nationalfootballleague.ui.screens.teamdetails

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.Athletes
import com.sgut.android.nationalfootballleague.NextEvent3
import com.sgut.android.nationalfootballleague.domain.domainmodels.TeamDetailWithRosterModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.FullTeamDetailWithRosterModel
import com.sgut.android.nationalfootballleague.domain.repositories.EspnRepository
import com.sgut.android.nationalfootballleague.domain.repositories.TeamDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamDetailViewModel @Inject constructor(
    private val espnRepository: EspnRepository,
    private val teamDetailsRepository: TeamDetailsRepository
): ViewModel() {

    private val _teamDetailUiState = MutableStateFlow(TeamDetailsScreenUiState())
    val  teamDetailUiState: StateFlow<TeamDetailsScreenUiState> = _teamDetailUiState


    val team: MutableState<TeamDetailWithRosterModel?> = mutableStateOf(null)
    val atheletes: MutableState<List<Athletes?>> = mutableStateOf(listOf())
    val nextEvents: MutableState<List<NextEvent3?>> = mutableStateOf(listOf())



    init {

//        loadTeamDetails()

    }

    // able to just pass TeamModel ?
    fun getFullTeamDetails(teamAbrv: String, sport: String, league: String) = viewModelScope.launch {
            val teamDetails = teamDetailsRepository.getSpecificTeam(sport, league, teamAbrv)
           setTeamDetailUiState(teamDetails, sport, league)

    }

//    fun loadTeamDetails(teamAbv: String, sport:String, league: String) = viewModelScope.launch {
//        try {
//            val result = espnRepository.getSpecificTeam(sport, league, teamAbv)
//            team.value = result
//            atheletes.value = result.athletes
//            nextEvents.value = result.nextEvent
//
//            setTeamDetailUiState(result, sport, league)
//
//        } catch (e: Exception){
//            Log.i("DEBUG-TEAM DETAIL",e.message.toString())
//        }
//    }

    fun setTeamDetailUiState(
        team: FullTeamDetailWithRosterModel,
        sport: String,
        league: String,
    ) {
        _teamDetailUiState.update {
            it.copy(
                currentSport = sport,
                currentLeague = league,
                currentTeamDetails = team,
                atheletes = team.athletes,
                nextEvents = team.nextEvent
            )
        }
    }
}

object HexToJetpackColor {
    fun getColor(colorString: String): Color {
        return Color(android.graphics.Color.parseColor("#" + colorString))
    }
}