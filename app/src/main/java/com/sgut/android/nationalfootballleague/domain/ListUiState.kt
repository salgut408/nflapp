package com.sgut.android.nationalfootballleague.domain

import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDomainModel

 data class ListUiState(

    var currentTeam: List<TeamDomainModel> = listOf(),
    var currentSport: String = "",
    var currentLeague: String = ""

)
