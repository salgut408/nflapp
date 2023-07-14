package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsVenueModel


data class GameDetailsVenue(

  @SerializedName("id")
  val id: String = "",
  @SerializedName("fullName")
  val fullName: String = "",
  @SerializedName("address")
  val address: GameDetailsAddress = GameDetailsAddress(),
  @SerializedName("capacity")
  val capacity: Int = 0,
  @SerializedName("grass")
  val grass: Boolean = false,
  @SerializedName("images")
  val images: List<GameDetailsImages> = listOf(),

  )

fun GameDetailsVenue.asDomain(): GameDetailsVenueModel {
  return GameDetailsVenueModel(
    id = id,
    fullName = fullName,
    address = address.asDomain(),
    capacity = capacity,
    grass = grass,
    images = images
  )
}