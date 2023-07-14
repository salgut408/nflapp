package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.CompetitorsModel


data class Competitors3(

  @SerializedName("id")
  val id: String? = null,
  @SerializedName("type")
  val type: String? = null,
  @SerializedName("order")
  val order: Int? = null,
  @SerializedName("homeAway")
  val homeAway: String? = null,
  @SerializedName("team")
  val team: Team3? = Team3(),

  )

fun Competitors3.asDomain(): CompetitorsModel {
  return CompetitorsModel(
    id = id ?: "",
    type = type ?: "",
    order = order ?: 0,
    homeAway = homeAway ?: "",
    team = team?.asDomain()
  )
}