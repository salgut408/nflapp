package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class PickcenterModel(
    val provider: ProviderModel = ProviderModel(),
    val details: String = "",
    val overUnder: Double = 0.0,
    val spread: Double = 0.0,
    val awayTeamOdds: AwayTeamOddsModel = AwayTeamOddsModel(),
    val homeTeamOdds: HomeTeamOddsModel = HomeTeamOddsModel(),

    )
