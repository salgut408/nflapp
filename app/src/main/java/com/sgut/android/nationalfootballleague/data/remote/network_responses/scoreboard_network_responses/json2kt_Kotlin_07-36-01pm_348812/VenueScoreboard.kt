package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardVenueModel


data class VenueScoreboard (

  @SerializedName("id" )
  val id : String? = null

)

fun VenueScoreboard.asDomain(): ScoreboardVenueModel {
  return ScoreboardVenueModel(
    id = id ?: ""
  )
}