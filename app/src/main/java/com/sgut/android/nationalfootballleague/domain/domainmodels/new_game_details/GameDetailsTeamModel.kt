package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class GameDetailsTeamModel(
    val team: GameDetailsTeamInfoModel? = GameDetailsTeamInfoModel(),
    val statistics: List<GameDetailsStatisticModel> = listOf(),
)
