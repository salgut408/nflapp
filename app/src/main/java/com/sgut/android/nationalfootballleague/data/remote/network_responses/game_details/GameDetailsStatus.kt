package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsStatusModel


data class GameDetailsStatus(

  @SerializedName("type")
  val type: GameDetailsType? = GameDetailsType(),
  @SerializedName("periodPrefix")
  val periodPrefix: InningPrefix? =InningPrefix.PRE,
  )

enum class InningPrefix {
  @SerializedName("Mid")
  MID,
  @SerializedName("Top")
  TOP,
  @SerializedName("Pre")
  PRE,
  @SerializedName("Bottom")
  BOTTOM,
  @SerializedName("End")
  END,
  @SerializedName("Start")
  START
}

fun GameDetailsStatus.asDomain(): GameDetailsStatusModel {
  return GameDetailsStatusModel(
    type = type?.asDomain(),
    periodPrefix = periodPrefix
  )
}