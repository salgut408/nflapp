package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardRecordModel


data class RecordsScoreboard(

  @SerializedName("name")
  val name: String? = null,
  @SerializedName("type")
  val type: String? = null,
  @SerializedName("summary")
  val summary: String? = null,
  @SerializedName("abbreviation")
  val abbreviation: String? = null,

  )

fun RecordsScoreboard.asDomain(): ScoreboardRecordModel {
  return ScoreboardRecordModel(
    name = name ?: "",
    type = type ?: "",
    summary = summary ?: "",
    abbreviation = abbreviation ?: ""
  )
}