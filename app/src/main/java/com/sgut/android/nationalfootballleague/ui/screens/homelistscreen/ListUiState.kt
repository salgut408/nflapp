package com.sgut.android.nationalfootballleague.ui.screens.homelistscreen

import com.sgut.android.nationalfootballleague.domain.domainmodels.SportState
import com.sgut.android.nationalfootballleague.domain.domainmodels.TeamDomainModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models.FullTeamsModel

data class ListUiState(
    var currentTeams: List<TeamDomainModel> = listOf(),
    var currentSport: String = "",
    var currentLeague: String = "",
    val sportState: SportState? = null,
    var fullTeamInfo: FullTeamsModel? = null
    )
