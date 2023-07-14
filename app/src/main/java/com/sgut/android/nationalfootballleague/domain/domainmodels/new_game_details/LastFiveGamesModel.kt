package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class LastFiveGamesModel(
    val team: GameDetailsTeamInfoModel = GameDetailsTeamInfoModel(),
    val lastEvents: List<GameDetailsEventModel> = listOf(),
)
