package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list

data class LeagueModel(
    val id: String = "",
    val uid: String = "",
    val name: String = "",
    val abbreviation: String = "",
    val shortName: String = "",
    val slug: String = "",
    val teams: List<TeamModel> = listOf()
)

