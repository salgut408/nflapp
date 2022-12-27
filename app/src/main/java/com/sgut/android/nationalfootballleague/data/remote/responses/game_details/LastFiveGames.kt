package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class LastFiveGames (

  @SerializedName("team"   ) var team   : GameDetailsTeam             = GameDetailsTeam(),
  @SerializedName("events" ) var lastEvents : List<GameDetailsEvents> = listOf()

)