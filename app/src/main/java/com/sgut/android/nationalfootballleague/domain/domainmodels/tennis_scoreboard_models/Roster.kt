package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class Roster(
    val athletes: List<AthleteX> = listOf(),
    val displayName: String = "",
    val shortDisplayName: String = ""
)