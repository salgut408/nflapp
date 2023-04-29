package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardAthleteInvolvedModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.TeamModel


data class AthletesInvolvedScoreboard(

  @SerializedName("id")
  val id: String? = null,
  @SerializedName("displayName")
  val displayName: String? = null,
  @SerializedName("shortName")
  val shortName: String? = null,
  @SerializedName("fullName")
  val fullName: String? = null,
  @SerializedName("jersey")
  val jersey: String? = null,
  @SerializedName("team")
  val team: Team? = Team(),
  @SerializedName("links")
  val links: ArrayList<LinksScoreboard> = arrayListOf(),
  @SerializedName("position")
  val position: String? = null,

  )

fun AthletesInvolvedScoreboard.asDomain(): ScoreboardAthleteInvolvedModel {
  return ScoreboardAthleteInvolvedModel(
    id = id ?: "",
    displayName = displayName ?: "",
    shortName = shortName ?: "",
    fullName = fullName ?: "",
    jersey = jersey ?: "",
    team = team?.asDomainModel() ?: TeamModel(),
    position = position ?: ""
  )
}
