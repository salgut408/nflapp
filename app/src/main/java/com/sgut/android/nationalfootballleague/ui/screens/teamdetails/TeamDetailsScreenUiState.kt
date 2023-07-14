package com.sgut.android.nationalfootballleague.ui.screens.teamdetails

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.AthletesRosterModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.FullTeamDetailWithRosterModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.NextEventModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleDomainModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_stats_models.TeamStatsModel

data class TeamDetailsScreenUiState(
    var currentSport: String = "",
    var currentLeague: String = "",
    val currentTeamDetails: FullTeamDetailWithRosterModel = FullTeamDetailWithRosterModel(),
    val atheletes: List<AthletesRosterModel> = listOf(),
    val nextEvents: List<NextEventModel> = listOf(),
    val schedule: ScheduleDomainModel = ScheduleDomainModel(),
    val stats: TeamStatsModel = TeamStatsModel()
//    val loading: Boolean = true
    )
