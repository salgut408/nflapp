package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class OddsModel(
    val provider: ProviderModel = ProviderModel(),
    val bettingOdds: BettingOddsModel = BettingOddsModel(),
)

data class BettingOddsModel(
    val homeTeam : GameDetailsHomeTeamModel = GameDetailsHomeTeamModel(),
    val awayTeam : GameDetailsAwayTeamModel = GameDetailsAwayTeamModel(),
//    val teamOdds : TeamOddsModel? = TeamOdds()
)

