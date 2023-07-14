package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class GameInfoModel(
    val venue   : GameDetailsVenueModel   = GameDetailsVenueModel(),
    val weather : WeatherModel = WeatherModel(),
    val attendance: Int = 0,
    val officials: List<OfficialModel> = listOf()

)


data class OfficialModel(
    val displayName: String? = "",
    val order: Int? = 0,
    val position: OfficialsPositionModel = OfficialsPositionModel()
)

data class OfficialsPositionModel(
    val displayName: String? = "",
    val id: String? = "",
    val name: String? = ""
)
