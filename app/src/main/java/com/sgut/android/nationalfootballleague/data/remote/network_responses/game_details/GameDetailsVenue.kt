package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsVenueModel


data class GameDetailsVenue(

  @SerializedName("id")
  val id: String? = null,
  @SerializedName("fullName")
  val fullName: String? = null,
  @SerializedName("address")
  val address: GameDetailsAddress? = GameDetailsAddress(),
  @SerializedName("capacity")
  val capacity: Int? = null,
  @SerializedName("grass")
  val grass: Boolean? = null,
  @SerializedName("images")
  val images: List<GameDetailsImages> = listOf(),

  )

fun GameDetailsVenue.asDomain(): GameDetailsVenueModel {
  return GameDetailsVenueModel(
    id = id ?: "",
    fullName = fullName ?: "",
    address = address?.asDomain(),
    capacity = capacity ?: 0,
    grass = grass ?: false,
    images = images
  )
}