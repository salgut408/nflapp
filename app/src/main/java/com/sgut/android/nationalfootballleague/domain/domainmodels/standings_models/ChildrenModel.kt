package com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models

data class ChildrenModel(
    val abbreviation: String = "",
    val id: String = "",
    val name: String = "",
    val shortName: String = "",
    val standings: StandingsResponseModel = StandingsResponseModel(),
    val uid: String = ""
)