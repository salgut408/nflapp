package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class HomeTeamOddsModel(
    val favorite: Boolean = false,
    val underdog: Boolean = false,
    val moneyLine: Float = 0f,
    val spreadOdds: Float = 0f,
    val teamId: String = "",
)
