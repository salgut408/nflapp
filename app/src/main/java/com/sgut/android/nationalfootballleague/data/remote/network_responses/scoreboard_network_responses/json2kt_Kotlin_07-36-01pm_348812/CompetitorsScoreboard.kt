package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardCompetitorsModel


data class CompetitorsScoreboard(

  @SerializedName("id")
  val id: String? = null,
  @SerializedName("uid")
  val uid: String? = null,
  @SerializedName("type")
  val type: String? = null,
  @SerializedName("order")
  val order: Int? = null,
  @SerializedName("homeAway")
  val homeAway: String? = null,
  @SerializedName("winner")
  val winner: Boolean? = null,
  @SerializedName("form")
  val form: String? = null,
  @SerializedName("score")
  val score: String? = null,
  @SerializedName("records")
  val records: List<RecordsScoreboard> = listOf(),
  @SerializedName("team")
  val team: TeamScoreboard = TeamScoreboard(),
  @SerializedName("statistics")
  val statistics: List<StatisticsScoreboard> = listOf(),

  )

fun CompetitorsScoreboard.asDomain(): ScoreboardCompetitorsModel {
  return ScoreboardCompetitorsModel(
    id = id ?: "",
    uid = uid ?: "",
    type =  type ?: "",
    order = order ?: 0,
    homeAway = homeAway ?: "",
    winner = winner ?: false,
    score = score ?: "",
    records = records.map { it.asDomain() },
    team = team.asDomain(),
    statistics = statistics.map { it.asDomain() }


  )
}