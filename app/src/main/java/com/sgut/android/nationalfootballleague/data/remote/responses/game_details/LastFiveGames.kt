package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class LastFiveGames (

  @SerializedName("team"   ) var team   : Team?             = Team(),
  @SerializedName("events" ) var events : ArrayList<GameDetailsEvents> = arrayListOf()

)