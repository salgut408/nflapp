package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsBoxscore (

  @SerializedName("teams" ) var teams : List<GameDetailsTeams> = listOf()

)