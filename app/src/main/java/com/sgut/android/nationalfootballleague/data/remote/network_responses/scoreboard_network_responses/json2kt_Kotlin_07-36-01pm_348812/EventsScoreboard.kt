package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardEventModel


data class EventsScoreboard(

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
  @SerializedName("season")
  val season: SeasonScoreboard? = SeasonScoreboard(),
  @SerializedName("competitions")
  val competitions: List<CompetitionsScoreboard> = listOf(),
  @SerializedName("status")
  val status: StatusScoreboard = StatusScoreboard(),
  @SerializedName("links")
  val links: ArrayList<LinksScoreboard> = arrayListOf(),

  )

fun EventsScoreboard.asDomain(): ScoreboardEventModel {
  return  ScoreboardEventModel(
    id = id ?: "",
    uid = uid ?: "",
    date = date ?: "",
    name = name ?: "",
    shortName = shortName ?: "",
    competitions = competitions.map { it.asDomain() },
    status = status.asDomain()
  )
}