package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class FootballPlayModel(
    val type: GameDetailsTypeModel? = GameDetailsTypeModel(),
    val text: String = "",
    val awayScore: Int = 0,
    val homeScore: Int = 0,
    val period: Int = 0,
    val clock: String = "",
    val scoringPlay: Boolean = false,
    val wallclock: String = "",
    val statYardage: Int = 0,
)
