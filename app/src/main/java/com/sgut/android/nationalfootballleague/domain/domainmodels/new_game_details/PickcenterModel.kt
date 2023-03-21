package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class PickcenterModel(
    val provider: ProviderModel = ProviderModel(),
    val details: String = "",
    val overUnder: Float = 0f,
    val spread: Float = 0f,
    val awayTeamOdds: AwayTeamOddsModel = AwayTeamOddsModel(),
    val homeTeamOdds: HomeTeamOddsModel = HomeTeamOddsModel(),

    )
