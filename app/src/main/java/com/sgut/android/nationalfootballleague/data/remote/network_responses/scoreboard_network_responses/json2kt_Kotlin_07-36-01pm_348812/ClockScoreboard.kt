package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardClockModel


data class ClockScoreboard(

  @SerializedName("value")
  val value: Int? = null,
  @SerializedName("displayValue")
  val displayValue: String? = null,

  )

fun ClockScoreboard.asDomain(): ScoreboardClockModel {
  return ScoreboardClockModel(
    value = value ?: 0,
    displayValue = displayValue ?: ""
  )
}