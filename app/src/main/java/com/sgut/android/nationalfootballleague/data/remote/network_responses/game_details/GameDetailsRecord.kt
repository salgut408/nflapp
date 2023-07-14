package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsRecordModel


data class GameDetailsRecord(

  @SerializedName("type")
  val type: String? = null,
  @SerializedName("summary")
  val summary: String? = null,
  @SerializedName("displayValue")
  val displayValue: String? = null,

  )

fun GameDetailsRecord.asDomain(): GameDetailsRecordModel {
  return GameDetailsRecordModel(
    type = type ?: "",
    summary = summary ?: "",
    displayValue = displayValue ?: ""
  )
}