package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class GameDetailsAthleteModel(
    val athlete: GameDetailsAthleteDetailsModel? = GameDetailsAthleteDetailsModel(),
    val stats: List<String> = listOf(),
)
