package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

import com.sgut.android.nationalfootballleague.GameDetailsStatus

data class GameDetailsCompetitionModel(
    val id: String = "",
    val date: String = "",
    val competitors: List<GameDetailsCompetitorModel> = listOf(),
    val status: GameDetailsStatus? = GameDetailsStatus(),
    val shotChartAvailable: Boolean = false,
    val timeoutsAvailable: Boolean = false,
    val possessionArrowAvailable: Boolean = false,
)


data class GameDetailsCompetitorModel(
    val id: String = "",
    val order: Int = 0,
    val isHomeOrAway: String = "",
    val team: GameDetailsTeamInfoModel? = GameDetailsTeamInfoModel(),
    val record: List<GameDetailsRecordModel> = listOf(),
    val possession: Boolean = false,
)