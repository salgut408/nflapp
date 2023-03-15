package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardRegulationModel


data class RegulationScoreboard (

  @SerializedName("periods")
  val periods : Int? = null

)
fun RegulationScoreboard.asDomain(): ScoreboardRegulationModel {
  return ScoreboardRegulationModel(
    periods = periods ?: 0
  )
}