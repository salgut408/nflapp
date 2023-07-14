package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsPositionModel


data class Position(

  @SerializedName("id") val id: String = "",
  @SerializedName("name") val name: String = "",
  @SerializedName("displayName") val displayName: String = "",
  @SerializedName("abbreviation") val abbreviation: String = "",
  @SerializedName("leaf") val leaf: Boolean? = null,
  @SerializedName("parent") val parent: Parent3? = Parent3(),

  )

fun Position.asDomain(): GameDetailsPositionModel {
  return GameDetailsPositionModel(
    name = name,
    displayName = displayName,
    abbreviation =  abbreviation
  )
}