package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsLeaders (

  @SerializedName("team"    ) var team    : GameDetailsTeam?              = GameDetailsTeam(),
//  @SerializedName("leaders" ) var leaders : ArrayList<GameDetailsLeaders> = arrayListOf()

)