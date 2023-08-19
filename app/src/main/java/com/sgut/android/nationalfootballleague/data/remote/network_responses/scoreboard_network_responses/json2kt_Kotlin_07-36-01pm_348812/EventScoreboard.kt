package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.DefaultScoreboardEventModel


data class EventScoreboard(

  @SerializedName("id")
  val id: String? = null,
  @SerializedName("uid")
  val uid: String? = null,
  @SerializedName("date")
  val date: String? = null,
  @SerializedName("name")
  val name: String? = null,
  @SerializedName("shortName")
  val shortName: String? = null,
  @SerializedName("competitions")
  val competitions: List<CompetitionScoreboard> = listOf(),
  @SerializedName("status")
  val status: StatusScoreboard = StatusScoreboard(),

  )

fun EventScoreboard.asDomain(): DefaultScoreboardEventModel {
  return  DefaultScoreboardEventModel(
    id = id ?: "",
    uid = uid ?: "",
    date = date ?: "",
    name = name ?: "",
    shortName = shortName ?: "",
    competitions = competitions.map { it.asDomain() },
    status = status.asDomain()
  )
}