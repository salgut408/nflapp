package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

import com.sgut.android.nationalfootballleague.GameDetailsImages
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.AddressModel

data class GameDetailsVenueModel(
    val id: String = "",
    val fullName: String = "",
    val address: AddressModel = AddressModel(),
    val capacity: Int = 0,
    val grass: Boolean = false,
    val images: List<GameDetailsImages> = listOf(),
)
