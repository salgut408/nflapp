package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class SituationModel(
    val lastPlay: LastPlayModel? = LastPlayModel(),
    val balls: Int = 0,
    val strikes: Int = 0,
    val outs: Int = 0,
    val pitcher: PitcherModel? = PitcherModel(),
    val batter: BatterModel? = BatterModel(),
)
data class BatterModel(
    val playerId: Int = 0,
    )

data class PitcherModel(
    val playerId: Int = 0,

    )

data class LastPlayModel(
    val id: String = ""
)
