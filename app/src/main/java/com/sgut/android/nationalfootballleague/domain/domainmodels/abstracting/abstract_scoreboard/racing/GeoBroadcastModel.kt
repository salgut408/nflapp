package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.racing

data class GeoBroadcastModel(
    val lang: String = "",
    val market: MarketModel = MarketModel(),
    val media: MediaModel = MediaModel(),
    val region: String = "",
    val type: TypeModel = TypeModel()
)