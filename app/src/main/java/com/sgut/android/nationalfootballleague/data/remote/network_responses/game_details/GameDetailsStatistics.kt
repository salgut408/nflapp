package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsStatisticModel


data class GameDetailsStatistics(

  @SerializedName("name")
  val name: String? = null,
  @SerializedName("displayValue")
  val displayValue: String? = null,
  @SerializedName("label")
  val label: String? = null,

  )
fun GameDetailsStatistics.asDomain(): GameDetailsStatisticModel {
  return GameDetailsStatisticModel(
    name = name ?: "",
    displayValue = displayValue ?: "",
    label = label ?: ""
  )
}