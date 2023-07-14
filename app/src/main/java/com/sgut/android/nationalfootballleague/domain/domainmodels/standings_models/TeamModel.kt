package com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models

data class TeamModel(
    val abbreviation: String = "",
    val displayName: String = "",
    val id: String = "",
    val location: String = "",
    val logos: List<LogoModel> = listOf(),
    val name: String = "",
    val shortDisplayName: String = "",
    val uid: String = ""
)