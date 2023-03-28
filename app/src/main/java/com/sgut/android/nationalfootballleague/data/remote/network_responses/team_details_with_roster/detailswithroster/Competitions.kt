package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.CompetitionsEventModel


data class Competitions3(

  @SerializedName("id")
  val id: String? = null,
  @SerializedName("date")
  val date: String? = null,
  @SerializedName("attendance")
  val attendance: Int? = null,
  @SerializedName("type")
  val type: Type3? = Type3(),
  @SerializedName("timeValid")
  val timeValid: Boolean? = null,
  @SerializedName("neutralSite")
  val neutralSite: Boolean? = null,
  @SerializedName("boxscoreAvailable")
  val boxscoreAvailable: Boolean? = null,
  @SerializedName("ticketsAvailable")
  val ticketsAvailable: Boolean? = null,
  @SerializedName("venue")
  val venue: Venue3 = Venue3(),
  @SerializedName("competitors")
  val competitors: List<Competitors3> = listOf(),
//  @SerializedName("notes")
//  val notes: List<String> = listOf(),
  @SerializedName("tickets")
  val tickets: List<Tickets3> = listOf(),
  @SerializedName("status")
  val status: Status3? = Status3(),
  )
fun Competitions3.asDomain(): CompetitionsEventModel {
  return CompetitionsEventModel(
    id = id ?: "",
    date = date ?: "",
    attendance = attendance ?: 0,
    type = type?.asDomain(),
    timeValid = timeValid,
    boxscoreAvailable = boxscoreAvailable,
    venue = venue.asDomain(),
    competitors = competitors.map { it.asDomain() },
    status = status?.asDomain(),
    tickets = tickets.map { it.asDomain() }
  )
}