package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class GameDetailsAthleteDetailsModel(
    val id: String = "",
    val uid: String = "",
    val lastName: String = "",
    val fullName: String = "",
    val displayName: String = "",
    val shortName: String = "",
    val headshot: GameDetailsHeadshotModel? = GameDetailsHeadshotModel(),
    val jersey: String = "",
    val position: GameDetailsPositionModel? = GameDetailsPositionModel(),
//    val bats: BatsModel = BatsModel(),
//    val throws: ThrowModel = ThrowModel(),
    )
data class GameDetailsAthleteDetailsModel4(
    val id: String = "",
    val uid: String = "",
    val lastName: String = "",
    val fullName: String = "",
    val displayName: String = "",
    val shortName: String = "",
    val headshot: String? = "",
    val jersey: String = "",
    val position: GameDetailsPositionModel? = GameDetailsPositionModel(),
//    val bats: BatsModel = BatsModel(),
//    val throws: ThrowModel = ThrowModel(),
)





data class BatsModel(
    val type: String = "",
    val abbreviation: String = "",
    val displayValue: String = ""
)

data class ThrowModel(
    val type: String = "",
    val abbreviation: String = "",
    val displayValue: String = ""
)
