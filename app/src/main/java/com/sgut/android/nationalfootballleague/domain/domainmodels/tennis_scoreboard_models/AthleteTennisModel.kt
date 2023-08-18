package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class AthleteTennisModel(
    val displayName: String = "",
    val flag: FlagTennisModel = FlagTennisModel(),
    val fullName: String = "",
    val guid: String = "",
    val shortName: String = ""
)