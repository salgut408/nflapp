package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models

data class SportModel(
    val id: String = "",
    val uid: String = "",
    val name: String = "",
    val slug: String = "",
    val leagues: List<LeagueModel> = listOf()
)
