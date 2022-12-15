package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class AgainstTheSpread (

  @SerializedName("team"    ) var team    : GameDetailsTeam?             = GameDetailsTeam(),
  @SerializedName("records" ) var records : ArrayList<String> = arrayListOf()

)