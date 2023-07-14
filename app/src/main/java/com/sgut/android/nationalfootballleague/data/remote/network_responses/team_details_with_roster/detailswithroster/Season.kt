package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.SeasonModel


data class Season3(

  @SerializedName("year")
  val year: Int? = null,
  @SerializedName("displayName")
  val displayName: String? = null,
  )

fun Season3.asDomain(): SeasonModel {
  return SeasonModel(
    year = year ?: 0,
    displayName = displayName ?: ""
  )
}