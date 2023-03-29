package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsPositionModel


data class GameDetailsPosition(

  @SerializedName("name")
  val name: String = "",
  @SerializedName("displayName")
  val displayName: String = "",
  @SerializedName("abbreviation")
  val abbreviation: String = "",

  )

fun GameDetailsPosition.asDomain(): GameDetailsPositionModel {
  return GameDetailsPositionModel(
    name = name ,
    displayName = displayName ,
    abbreviation = abbreviation
  )
}