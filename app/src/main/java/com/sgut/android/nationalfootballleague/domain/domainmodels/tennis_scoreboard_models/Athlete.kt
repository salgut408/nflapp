package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class Athlete(
    val displayName: String = "",
    val flag: Flag = Flag(),
    val fullName: String = "",
    val guid: String = "",
    val links: List<LinkXX> = listOf(),
    val shortName: String = ""
)