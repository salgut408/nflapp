package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class GameDetailsCompetitorModel(
    val id: String = "",
    val order: Int = 0,
    val isHomeOrAway: String = "",
    val team: GameDetailsTeamInfoModel? = GameDetailsTeamInfoModel(),
    val record: List<GameDetailsRecordModel> = listOf(),
    val possession: Boolean = false,
)