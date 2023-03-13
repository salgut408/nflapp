package com.sgut.android.nationalfootballleague.ui.screens.homelistscreen

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.FullTeamsListsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.TeamModel

data class ListUiState(
    val currentTeams: List<TeamModel> = listOf(),
    val currentSport: String = "",
    val currentLeague: String = "",
    val fullTeamInfo: FullTeamsListsModel? = null
    )
