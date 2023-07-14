package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class GameDetailsStatisticModel(
    val name: String = "",
    val displayValue: String = "",
    val label: String = "",
)

data class GameDetailsStatModel(
    val name: String = "",
    val displayName: String = "",
    val shortDisplayName: String = "",
    val description: String = "",
    val abbreviation: String = "",
    val type: String = "",
    val value: Double = 0.0,
    val displayValue: String = "",
)
