package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class GameDetailsFormatModel(
    val regulation: GameDetailsRegulationModel = GameDetailsRegulationModel(),
    val overtime: GameDetailsOvertimeModel = GameDetailsOvertimeModel(),
    )
