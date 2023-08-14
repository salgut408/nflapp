package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class PreviousWinner(
    val athletes: List<AthleteXX> = listOf(),
    val displayName: String = "",
    val headshot: String = "",
    val shortDisplayName: String = "",
    val type: TypeX = TypeX()
)