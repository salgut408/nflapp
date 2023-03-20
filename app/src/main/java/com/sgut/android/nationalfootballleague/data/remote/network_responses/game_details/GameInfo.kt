package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameInfo (

  @SerializedName("venue"   )
  val venue   : GameDetailsVenue?   = GameDetailsVenue(),
  @SerializedName("weather" )
  val weather : Weather? = Weather()

)