package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.racing

data class StatusModelX(
    val clock: Double = 0.0,
    val displayClock: String = "",
    val period: Int = 0,
    val type: TypeModelX = TypeModelX()
)