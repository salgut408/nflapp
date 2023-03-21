package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsFormatModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsOvertimeModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsRegulationModel


data class GameDetailsFormat(

  @SerializedName("regulation")
  val regulation: GameDetailsRegulation? = GameDetailsRegulation(),
  @SerializedName("overtime")
  val overtime: GameDetailsOvertime? = GameDetailsOvertime(),

  )

fun GameDetailsFormat.asDomain(): GameDetailsFormatModel {
  return GameDetailsFormatModel(
    regulation = regulation?.asDomain() ?: GameDetailsRegulationModel(),
    overtime = overtime?.asDomain() ?: GameDetailsOvertimeModel()
  )
}