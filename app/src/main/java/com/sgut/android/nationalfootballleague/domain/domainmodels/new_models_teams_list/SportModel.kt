package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list

data class SportModel(
    val id: String = "",
    val uid: String = "",
    val name: String = "",
    val slug: String = "",
    val league: LeagueModel = LeagueModel()
)
