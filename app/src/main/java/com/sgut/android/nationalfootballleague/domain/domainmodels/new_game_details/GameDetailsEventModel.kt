package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class GameDetailsEventModel(
    val id: String = "",
    val atVs: String = "",
    val gameDate: String = "",
    val score: String = "",
    val homeTeamScore: String = "",
    val awayTeamScore: String = "",
    val gameResult: String = "",
    val opponent: GameDetailsOpponentModel = GameDetailsOpponentModel(),
    val opponentLogo: String = "",
    val  leagueName: String = "",
    val leagueAbbreviation: String = "",
    )
