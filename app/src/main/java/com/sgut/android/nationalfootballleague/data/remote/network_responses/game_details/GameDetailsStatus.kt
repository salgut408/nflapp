package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsStatusModel


data class GameDetailsStatus(

  @SerializedName("type")
  val type: GameDetailsType? = GameDetailsType(),


  )

fun GameDetailsStatus.asDomain(): GameDetailsStatusModel {
  return GameDetailsStatusModel(
    type = type?.asDomain()
  )
}