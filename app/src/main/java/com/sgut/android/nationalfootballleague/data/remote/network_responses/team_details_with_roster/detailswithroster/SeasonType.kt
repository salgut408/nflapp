package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.SeasonTypeModel


data class SeasonType3(
  @SerializedName("id")
  val id: String? = null,
  @SerializedName("type")
  val type: Int? = null,
  @SerializedName("name")
  val name: String? = null,
  @SerializedName("abbreviation")
  val abbreviation: String? = null,
  )

fun SeasonType3.asDomain(): SeasonTypeModel {
  return SeasonTypeModel(
    id = id ?: "",
    type = type ?: 0,
    name = name ?: "",
    abbreviation = abbreviation ?: ""
  )
}