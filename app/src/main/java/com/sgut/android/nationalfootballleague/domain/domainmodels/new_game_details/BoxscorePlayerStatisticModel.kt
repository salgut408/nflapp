package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class BoxscorePlayerStatisticModel(
    val name: String = "",
    val keys: List<String> = listOf(),
    val text: String = "",
    val labels: List<String> = listOf(),
    val descriptions: List<String> = listOf(),
    val athletes: List<GameDetailsAthleteModel> = listOf(),
    val totals: List<String> = listOf(),
)
