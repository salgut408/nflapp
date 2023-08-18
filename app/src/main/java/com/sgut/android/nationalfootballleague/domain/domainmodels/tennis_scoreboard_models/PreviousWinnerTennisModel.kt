package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class PreviousWinnerTennisModel(
    val athletes: List<AthleteTennisModelXX> = listOf(),
    val displayName: String = "",
    val headshot: String = "",
    val shortDisplayName: String = "",
    val type: TypeTennisModelX = TypeTennisModelX()
)