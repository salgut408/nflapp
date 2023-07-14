package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardFormatModel


data class FormatScoreboard(

  @SerializedName("regulation")
  val regulation: RegulationScoreboard? = RegulationScoreboard(),

  )

fun FormatScoreboard.asDomain(): ScoreboardFormatModel {
  return ScoreboardFormatModel(
    regulation = regulation?.asDomain()
  )
}