package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class GameInfoModel(
    val venue   : GameDetailsVenueModel   = GameDetailsVenueModel(),
    val weather : WeatherModel = WeatherModel(),
    val attendance: Int = 0

)
