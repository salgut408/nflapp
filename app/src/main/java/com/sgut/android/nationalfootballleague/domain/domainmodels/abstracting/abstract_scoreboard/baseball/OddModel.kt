package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.baseball

data class OddModel(
    val details: String = "",
    val overUnder: Double = 0.0,
    val provider: ProviderModel = ProviderModel()
)