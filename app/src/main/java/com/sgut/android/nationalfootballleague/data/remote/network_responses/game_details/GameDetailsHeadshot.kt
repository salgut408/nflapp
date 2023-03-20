package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsHeadshotModel


data class GameDetailsHeadshot (

  @SerializedName("href" )
  val href : String? = null,
  @SerializedName("alt"  )
  val alt  : String? = null

)
fun GameDetailsHeadshot.asDomain(): GameDetailsHeadshotModel {
  return GameDetailsHeadshotModel(
    href = href ?: "",
    alt = alt ?: ""
  )
}