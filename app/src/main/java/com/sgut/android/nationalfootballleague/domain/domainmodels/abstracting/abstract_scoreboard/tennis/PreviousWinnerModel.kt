package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.tennis

data class PreviousWinnerModel(
    val athletes: List<AthleteModelXX> = listOf(),
    val displayName: String = "",
    val headshot: String = "",
    val shortDisplayName: String = "",
    val type: TypeModelX = TypeModelX()
)