package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.PredictorModel


data class Predictor(

  @SerializedName("header")
  val header: String? = null,
  @SerializedName("homeTeam")
  val homeTeam: GameDetailsHomeTeam? = GameDetailsHomeTeam(),
  @SerializedName("awayTeam")
  val awayTeam: GameDetailsAwayTeam? = GameDetailsAwayTeam(),

  )

fun Predictor.asDomain(): PredictorModel {
  return PredictorModel(
    header = header,
    homeTeam = homeTeam?.asDomain(),
    awayTeam = awayTeam?.asDomain()
  )
}