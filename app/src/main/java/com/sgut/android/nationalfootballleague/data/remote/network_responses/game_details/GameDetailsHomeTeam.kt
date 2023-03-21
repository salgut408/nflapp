package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsHomeTeamModel


data class GameDetailsHomeTeam (

  @SerializedName("id" )
  val id : String? = null,
  @SerializedName("gameProjection" )
  val gameProjection : Float? = null,
  @SerializedName("teamChanceLoss" )
  val teamChanceLoss : Float? = null,
  @SerializedName("teamChanceTie" )
  val teamChanceTie : Float? = null,

  )
fun GameDetailsHomeTeam.asDomain(): GameDetailsHomeTeamModel {
  return GameDetailsHomeTeamModel(
    id = id,
    gameProjection = gameProjection,
    teamChanceLoss = teamChanceLoss,
    teamChanceTie = teamChanceTie,
  )

}
