package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class GameDetailsStatusModel (
    val type: GameDetailsTypeModel? = GameDetailsTypeModel(),
    val periodPrefix: String = ""
)