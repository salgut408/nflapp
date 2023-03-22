package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class GameDetailsCompetitionModel(
    val id: String = "",
    val date: String = "",
    val competitors: List<GameDetailsCompetitorModel> = listOf(),
    val status: GameDetailsStatusModel? = GameDetailsStatusModel(),
    val shotChartAvailable: Boolean = false,
    val timeoutsAvailable: Boolean = false,
    val possessionArrowAvailable: Boolean = false,
)





