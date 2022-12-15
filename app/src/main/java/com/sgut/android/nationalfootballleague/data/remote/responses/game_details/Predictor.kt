package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Predictor (

  @SerializedName("header"   ) var header   : String?   = null,
  @SerializedName("homeTeam" ) var homeTeam : GameDetailsHomeTeam? = GameDetailsHomeTeam(),
  @SerializedName("awayTeam" ) var awayTeam : GameDetailsAwayTeam? = GameDetailsAwayTeam()

)