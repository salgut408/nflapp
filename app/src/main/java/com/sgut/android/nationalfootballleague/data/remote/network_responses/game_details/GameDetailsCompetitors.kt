package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsCompetitorModel


data class GameDetailsCompetitors(

  @SerializedName("id")
  val id: String? = null,
  @SerializedName("uid")
  val uid: String? = null,
  @SerializedName("order")
  val order: Int? = null,
  @SerializedName("homeAway")
  val isHomeOrAway: String? = null,
  @SerializedName("team")
  val team: GameDetailsTeam? = GameDetailsTeam(),
  @SerializedName("record")
  val record: List<GameDetailsRecord> = listOf(),
  @SerializedName("possession")
  val possession: Boolean = false,
  @SerializedName("score")
  val score: Int = 0,
  @SerializedName("probables")
val probables: List<Probables> = listOf(),

)

fun GameDetailsCompetitors.asDomain(): GameDetailsCompetitorModel {
  return GameDetailsCompetitorModel(
    id = id ?: "" ,
    order = order ?: 0,
    isHomeOrAway = isHomeOrAway ?: "",
    team = team?.asDomain(),
    record = record.map { it.asDomain() },
    possession = possession,
    score = score,
    probables = probables.map { it.asDomain() }
  )
}