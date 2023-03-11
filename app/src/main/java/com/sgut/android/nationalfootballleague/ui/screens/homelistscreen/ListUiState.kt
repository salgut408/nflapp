package com.sgut.android.nationalfootballleague.ui.screens.homelistscreen

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models.FullTeamsListsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models.TeamModel

data class ListUiState(
    var currentTeams: List<TeamModel> = listOf(),
    var currentSport: String = "",
    var currentLeague: String = "",
    var fullTeamInfo: FullTeamsListsModel? = null
    )
