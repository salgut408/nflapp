package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsRegulationModel


data class GameDetailsRegulation(

  @SerializedName("periods")
  val periods: Int? = null,
  @SerializedName("displayName")
  val displayName: String? = null,
  @SerializedName("slug")
  val slug: String? = null,
  @SerializedName("clock")
  val clock: Int? = null,

  )

fun GameDetailsRegulation.asDomain(): GameDetailsRegulationModel {
  return GameDetailsRegulationModel(
    periods = periods ?: 0,
    displayName = displayName ?: "",
    slug = slug ?: "",
    clock = clock ?: 0
  )
}