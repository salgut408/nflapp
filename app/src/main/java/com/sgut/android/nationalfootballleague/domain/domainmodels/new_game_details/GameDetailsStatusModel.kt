package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class GameDetailsStatusModel (
    val type: GameDetailsTypeModel? = GameDetailsTypeModel(),
//    TODO MAke enum
    val periodPrefix: String = ""
)