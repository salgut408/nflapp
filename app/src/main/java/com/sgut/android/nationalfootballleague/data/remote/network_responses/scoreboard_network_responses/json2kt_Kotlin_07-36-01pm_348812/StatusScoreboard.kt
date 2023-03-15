package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.StatusDomainModel


data class StatusScoreboard(
  @SerializedName("clock")
  val clock: String? = null,
  @SerializedName("displayClock")
  val displayClock: String? = null,
  @SerializedName("period")
  val period: Int = 0,
  @SerializedName("type")
  val type: TypeScoreboard? = TypeScoreboard(),
  )

fun StatusScoreboard.asDomain() : StatusDomainModel {
  return StatusDomainModel(
    clock = clock?.toString() ?: "STATUS CLOCK",
    displayClock = displayClock ?: "",
    period = period,
    type = type?.asDomain()
  )
}