package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.LastFiveGamesModel


data class LastFiveGames(

  @SerializedName("team")
  val team: GameDetailsTeam = GameDetailsTeam(),
  @SerializedName("events")
  val lastEvents: List<GameDetailsEvents> = listOf(),

  )

fun LastFiveGames.asDomain(): LastFiveGamesModel {
  return LastFiveGamesModel(
    team = team.asDomain(),
    lastEvents = lastEvents.map { it.asDomain() }
  )
}