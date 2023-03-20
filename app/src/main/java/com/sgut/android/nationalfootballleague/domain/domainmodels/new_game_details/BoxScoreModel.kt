package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

import com.sgut.android.nationalfootballleague.GameDetailsTeams
import com.sgut.android.nationalfootballleague.Players
import com.sgut.android.nationalfootballleague.Statistics

data class BoxScoreModel(
    val teams : List<GameDetailsTeams> = listOf(),//needs mod
    val players : List<Players> = listOf(), // needs mod
    val statistics : List<Statistics> = listOf() // needs mod maybe
)
