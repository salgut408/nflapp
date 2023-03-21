package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class HeaderModel(
    val id: String = "",
    val uid: String = "",
    val timeValid: Boolean = false,
    val competitions: List<GameDetailsCompetitionModel> = listOf(),
    val week: Int = 0,
    val league: GameDetailsLeagueModel = GameDetailsLeagueModel(),
    val gameNote: String = "",
)

data class GameDetailsLeagueModel(
    val id: Int = 0,
    val description: String? = null,
    val name: String = "",
    val abbreviation: String = "",
)
