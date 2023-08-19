package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.baseball

data class DueUpModel(
    val athlete: AthleteModelXXX = AthleteModelXXX(),
    val batOrder: Int = 0,
    val period: Int = 0,
    val playerId: Int = 0,
    val summary: String = ""
)