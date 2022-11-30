package com.sgut.android.nationalfootballleague.homelistscreen

import com.sgut.android.nationalfootballleague.Athletes
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDomainModel

data class ListUiState(

    var currentTeam: List<TeamDomainModel> = listOf(),
    var currentSport: String = "",
    var currentLeague: String = "",


    )
