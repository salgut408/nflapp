package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class BoxScoreModel(
    val teams : List<GameDetailsTeamModel> = listOf(),
    val players : List<BoxscorePlayerModel> = listOf(),
    val statistics : List<BoxscorePlayerStatisticModel> = listOf()
)
