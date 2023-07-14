package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class PredictorModel(
    val header: String? = null,
    val homeTeam: GameDetailsHomeTeamModel? = GameDetailsHomeTeamModel(),
    val awayTeam: GameDetailsAwayTeamModel? = GameDetailsAwayTeamModel(),
)
