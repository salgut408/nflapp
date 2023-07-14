package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.SeatSituationModel


data class SeatSituation(

  @SerializedName("opponentTeamName")
  val opponentTeamName: String? = null,
  @SerializedName("currentTeamName")
  val currentTeamName: String? = null,
  @SerializedName("venueName")
  val venueName: String? = null,
  @SerializedName("summary")
  val summary: String? = null,
  @SerializedName("date")
  val date: String? = null,
  @SerializedName("dateShort")
  val dateShort: String? = null,
  @SerializedName("dateDay")
  val dateDay: String? = null,
  @SerializedName("homeAway")
  val homeAway: String? = null,
  @SerializedName("eventLink")
  val eventLink: String? = null,
  @SerializedName("venueLink")
  val venueLink: String? = null,
  @SerializedName("genericLink")
  val genericLink: String? = null,
  @SerializedName("teamLink")
  val teamLink: String? = null,

  )

fun SeatSituation.asDomain(): SeatSituationModel {
  return SeatSituationModel(
    opponentTeamName = opponentTeamName ?: "",
    currentTeamName = currentTeamName ?: "",
    venueName = venueName ?: "",
    summary = summary ?: "",
    date = date ?: "",
    dateDay = dateDay ?: "",
    dateShort = dateShort ?: "",
    homeAway = homeAway ?: "",
    eventLink = eventLink ?: "",
    venueLink = venueLink ?: "",
    genericLink = genericLink ?: "",
    teamLink = teamLink ?: "",
  )
}