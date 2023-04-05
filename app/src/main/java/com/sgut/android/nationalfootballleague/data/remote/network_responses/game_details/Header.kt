package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.HeaderModel


data class Header(
  @SerializedName("id")
  val id: String? = null,
  @SerializedName("uid")
  val uid: String? = null,
  @SerializedName("season")
  val season: GameDetailsSeason = GameDetailsSeason(),
  @SerializedName("timeValid")
  val timeValid: Boolean? = null,
  @SerializedName("competitions")
  val competitions: List<GameDetailsCompetitions> = listOf(),
  @SerializedName("week")
  val week: Int? = null,
  @SerializedName("league")
  val league: GameDetailsLeague = GameDetailsLeague(),
  @SerializedName("gameNote")
  val gameNote: String? = null,


  )





fun Header.asDomain(): HeaderModel {
  return HeaderModel(
    id = id ?: "",
    uid = uid ?: "",
    timeValid = timeValid ?: false,
    competitions = competitions.map { it.asDomain() },
    week = week ?: 0,
    league = league.asDomain() ,
    gameNote = gameNote ?: "",
  )
}