package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.baseball

data class StatusModel(
    val clock: Double = 0.0,
    val displayClock: String = "",
    val period: Int = 0,
    val type: TypeModelXX = TypeModelXX()
)