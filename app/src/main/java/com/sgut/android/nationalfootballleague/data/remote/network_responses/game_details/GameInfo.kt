package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameInfo (

  @SerializedName("venue"   ) var venue   : GameDetailsVenue?   = GameDetailsVenue(),
  @SerializedName("weather" ) var weather : Weather? = Weather()

)