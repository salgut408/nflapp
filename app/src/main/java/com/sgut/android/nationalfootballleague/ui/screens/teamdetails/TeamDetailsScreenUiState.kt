package com.sgut.android.nationalfootballleague.ui.screens.teamdetails

import com.sgut.android.nationalfootballleague.NextEvent3
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.AthletesRosterModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.FullTeamDetailWithRosterModel

data class TeamDetailsScreenUiState(
    var currentSport: String = "",
    var currentLeague: String = "",
    val currentTeamDetails: FullTeamDetailWithRosterModel = FullTeamDetailWithRosterModel(),
    val atheletes: List<AthletesRosterModel> = listOf(),
    val nextEvents: List<NextEvent3> = listOf(),
    )
