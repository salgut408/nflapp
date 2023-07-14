package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class WinprobabilityModel(
    val tiePercentage: Double = 0.0,
    val homeWinPercentage: Double = 0.0,
    val secondsLeft: Double = 0.0,
    val playId: String = "",
)
