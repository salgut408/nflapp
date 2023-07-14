package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.StatusDomainModel


data class Status3(

  @SerializedName("clock")
  val clock: Int? = null,
  @SerializedName("displayClock")
  val displayClock: String? = null,
  @SerializedName("period")
  val period: Int? = null,
  @SerializedName("type")
  val type: Type3? = Type3(),
  )
fun Status3.asDomain(): StatusDomainModel {
  return StatusDomainModel(
    clock = clock.toString(),
    displayClock = displayClock ?: "",
    period = period ?: 0,
    type = type?.asDomain()
  )
}