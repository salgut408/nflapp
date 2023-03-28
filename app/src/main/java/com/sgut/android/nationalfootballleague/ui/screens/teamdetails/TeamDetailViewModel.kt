package com.sgut.android.nationalfootballleague.ui.screens.teamdetails

import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule.ScheduleResponseNetwork
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.FullTeamDetailWithRosterModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleDomainModel
import com.sgut.android.nationalfootballleague.domain.repositories.TeamDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamDetailViewModel @Inject constructor(
    private val teamDetailsRepository: TeamDetailsRepository,
) : ViewModel() {

    private val _teamDetailUiState = MutableStateFlow(TeamDetailsScreenUiState())
    val teamDetailUiState: StateFlow<TeamDetailsScreenUiState> = _teamDetailUiState
    lateinit var sched: ScheduleResponseNetwork


    init {

    }

    // able to just pass TeamModel ? or team id with room?
    fun getFullTeamDetails(teamAbrv: String, sport: String, league: String) =
        viewModelScope.launch {
            val teamDetails = teamDetailsRepository.getSpecificTeam(sport, league, teamAbrv)
            val teamSched = teamDetailsRepository.getTeamSchedule(sport, league, teamAbrv )

            setTeamDetailUiState(teamDetails, sport, league, teamSched)
            Log.e("SCHED", teamSched.toString())
        }




    fun setTeamDetailUiState(
        team: FullTeamDetailWithRosterModel,
        sport: String,
        league: String,
        schedule: ScheduleDomainModel,
    ) {
        _teamDetailUiState.update {
            it.copy(
                currentSport = sport,
                currentLeague = league,
                currentTeamDetails = team,
                atheletes = team.athletes,
                nextEvents = team.nextEvent,
                schedule = schedule
            )
        }
    }
}

object HexToJetpackColor {
    fun getColor(colorString: String): Color {
        return Color(android.graphics.Color.parseColor("#" + colorString))
    }
}