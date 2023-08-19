package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.tennis

data class RosterModel(
    val athletes: List<AthleteModelX> = listOf(),
    val displayName: String = "",
    val shortDisplayName: String = ""
)