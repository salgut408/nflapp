package com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models

data class StandingsModel(
    val abbreviation: String = "",
    val children: List<ChildrenModel> = listOf(),
    val id: String = "",
    val name: String = "",
    val seasons: List<SeasonModel> = listOf(),
    val shortName: String = "",
    val uid: String = ""
)