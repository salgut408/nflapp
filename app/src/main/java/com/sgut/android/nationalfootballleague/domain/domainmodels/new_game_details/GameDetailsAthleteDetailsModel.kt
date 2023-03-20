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

    )
