package com.sgut.android.nationalfootballleague.ui.screens.homelistscreen

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.FullTeamsListsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.TeamModel

data class ListUiState(
    var currentTeams: List<TeamModel> = listOf(),
    var currentSport: String = "",
    var currentLeague: String = "",
    var fullTeamInfo: FullTeamsListsModel? = null
    )
