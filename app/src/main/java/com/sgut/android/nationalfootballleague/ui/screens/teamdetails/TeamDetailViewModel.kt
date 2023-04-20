package com.sgut.android.nationalfootballleague.ui.screens.teamdetails

import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.Position
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.AthletesRosterModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.FullTeamDetailWithRosterModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleDomainModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_stats_models.TeamStatsModel
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

     var playaMap: Map<AthletesRosterModel, Position>

    init {
      playaMap =  getPositionMap(_teamDetailUiState.value.atheletes)

    }

    // able to just pass TeamModel ? or team id with room?
    fun getFullTeamDetails(teamAbrv: String, sport: String, league: String) =
        viewModelScope.launch {
            val teamDetails = teamDetailsRepository.getSpecificTeam(sport, league, teamAbrv)
            val teamSched = teamDetailsRepository.getTeamSchedule(sport, league, teamAbrv )
            val stats = teamDetailsRepository.getTeamStats(sport, league, teamAbrv )

            setTeamDetailUiState(teamDetails, sport, league, teamSched, stats)
            Log.d("TEAM_STATS VM", stats.toString())
        }


    fun getPositionMap(list: List<AthletesRosterModel>): Map<AthletesRosterModel, Position> {
        val  map = list.associate { it to it.position }
        return map
    }


    private fun setTeamDetailUiState(
        team: FullTeamDetailWithRosterModel,
        sport: String,
        league: String,
        schedule: ScheduleDomainModel,
        stats: TeamStatsModel
    ) {
        _teamDetailUiState.update {
            it.copy(
                currentSport = sport,
                currentLeague = league,
                currentTeamDetails = team,
                atheletes = team.athletes.sortedBy { it.position.id },
                nextEvents = team.nextEvent,
                schedule = schedule,
                stats = stats
            )
        }
    }
}

object HexToJetpackColor {
    fun getColor(colorString: String): Color {
        return Color(android.graphics.Color.parseColor("#" + colorString))
    }
}