package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class Linescore(
    val tiebreak: Int = 0,
    val value: Double = 0.0,
    val winner: Boolean = false
)