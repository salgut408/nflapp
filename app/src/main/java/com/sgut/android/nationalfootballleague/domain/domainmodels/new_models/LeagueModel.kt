package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models

data class LeagueModel(
    val id: String = "",
    val uid: String = "",
    val name: String = "",
    val abbreviation: String = "",
    val shortName: String = "",
    val slug: String = "",
    val teams: List<TeamModel>

)

