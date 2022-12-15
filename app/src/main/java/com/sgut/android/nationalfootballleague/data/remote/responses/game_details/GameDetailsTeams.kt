package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsTeams (

  @SerializedName("team"       ) var team       : GameDetailsTeam?                 = GameDetailsTeam(),
  @SerializedName("statistics" ) var statistics : ArrayList<GameDetailsStatistics> = arrayListOf()

)