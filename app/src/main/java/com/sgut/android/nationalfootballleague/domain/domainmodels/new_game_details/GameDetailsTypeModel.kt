package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class GameDetailsTypeModel(
    val id: String = "",
    val name: String = "",
    val completed: Boolean = false,
    val description: String = "",
    val gameTimeDetail: String = "",
    val shortGameTimeDetail: String = "",
    val text: String = "",
    val abbreviation: String = "",
)