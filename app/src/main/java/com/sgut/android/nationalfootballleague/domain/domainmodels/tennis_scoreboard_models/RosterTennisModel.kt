package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class RosterTennisModel(
    val athletes: List<AthleteTennisModelX> = listOf(),
    val displayName: String = "",
    val shortDisplayName: String = ""
)