package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.AgainstTheSpreadModel


data class AgainstTheSpread(

  @SerializedName("team")
  val team: GameDetailsTeam? = GameDetailsTeam(),
  @SerializedName("records")
  val records: ArrayList<String> = arrayListOf(),

  )

fun AgainstTheSpread.asDomain(): AgainstTheSpreadModel {
  return AgainstTheSpreadModel(
    team = team?.asDomain(),
    records = records
  )
}