package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsStatModel


data class GameDetailsStats(

  @SerializedName("name")
  val name: String = "",
  @SerializedName("displayName")
  val displayName: String = "",
  @SerializedName("shortDisplayName")
  val shortDisplayName: String = "",
  @SerializedName("description")
  val description: String = "",
  @SerializedName("abbreviation")
  val abbreviation: String = "",
  @SerializedName("type")
  val type: String = "",
  @SerializedName("value")
  val value: Double = 0.0,
  @SerializedName("displayValue")
  val displayValue: String = "",

  )

fun GameDetailsStats.asDomain(): GameDetailsStatModel {
  return GameDetailsStatModel(
    name = name,
    displayName = displayName,
    shortDisplayName = shortDisplayName,
    description = description,
    abbreviation = abbreviation,
    type = type,
    value = value,
    displayValue = displayValue
  )
}