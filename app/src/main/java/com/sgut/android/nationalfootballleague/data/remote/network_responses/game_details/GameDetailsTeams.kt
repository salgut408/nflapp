package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsTeamModel


data class GameDetailsTeams(

  @SerializedName("team")
  val team: GameDetailsTeam? = GameDetailsTeam(),
  @SerializedName("statistics")
  val statistics: List<GameDetailsStatistics> = listOf(),

  )

fun GameDetailsTeams.asDomain(): GameDetailsTeamModel {
  return GameDetailsTeamModel(
    team = team?.asDomain(),
    statistics = statistics.map { it.asDomain() }
  )
}