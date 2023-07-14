package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardStatisticModel


data class StatisticsScoreboard(

  @SerializedName("name")
  val name: String? = null,
  @SerializedName("abbreviation")
  val abbreviation: String? = null,
  @SerializedName("displayValue")
  val displayValue: String? = null,

  )

fun StatisticsScoreboard.asDomain(): ScoreboardStatisticModel {
  return ScoreboardStatisticModel(
    name = name ?: "",
    abbreviation = abbreviation ?: "",
    displayValue = displayValue ?: ""
  )
}