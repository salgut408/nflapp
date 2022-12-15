package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class BettingOdds (

  @SerializedName("homeTeam" ) var homeTeam : GameDetailsHomeTeam? = GameDetailsHomeTeam(),
  @SerializedName("awayTeam" ) var awayTeam : GameDetailsAwayTeam? = GameDetailsAwayTeam(),
  @SerializedName("teamOdds" ) var teamOdds : TeamOdds? = TeamOdds()

)