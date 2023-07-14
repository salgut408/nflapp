package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class BoxscorePlayerModel(
    val team: GameDetailsTeamInfoModel = GameDetailsTeamInfoModel(),
    val statistics: List<BoxscorePlayerStatisticModel> = listOf(),
)
