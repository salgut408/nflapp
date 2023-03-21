package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameInfoModel


data class GameInfo (

  @SerializedName("venue"   )
  val venue   : GameDetailsVenue?   = GameDetailsVenue(),
  @SerializedName("weather" )
  val weather : Weather? = Weather()

)

fun GameInfo.asDomain(): GameInfoModel {
  return GameInfoModel(
    venue = venue?.asDomain(),
    weather = weather?.asDomain()
  )
}