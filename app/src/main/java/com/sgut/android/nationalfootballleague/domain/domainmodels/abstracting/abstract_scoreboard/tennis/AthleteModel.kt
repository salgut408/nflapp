package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.tennis

data class AthleteModel(
    val displayName: String = "",
    val flag: FlagModel = FlagModel(),
    val fullName: String = "",
    val guid: String = "",
    val links: List<LinkModelXX> = listOf(),
    val shortName: String = ""
)