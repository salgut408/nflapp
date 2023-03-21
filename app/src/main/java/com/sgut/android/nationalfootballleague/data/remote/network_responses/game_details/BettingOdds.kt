package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.BettingOddsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsAwayTeamModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsHomeTeamModel


data class BettingOdds (

  @SerializedName("homeTeam" )
  val homeTeam : GameDetailsHomeTeam? = GameDetailsHomeTeam(),
  @SerializedName("awayTeam" )
  val awayTeam : GameDetailsAwayTeam? = GameDetailsAwayTeam(),
  @SerializedName("teamOdds" )
  val teamOdds : TeamOdds? = TeamOdds()

)

fun BettingOdds.asDomain(): BettingOddsModel {
  return BettingOddsModel(
    homeTeam = homeTeam?.asDomain() ?: GameDetailsHomeTeamModel(),
    awayTeam = awayTeam?.asDomain() ?: GameDetailsAwayTeamModel()
  )
}