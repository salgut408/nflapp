package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsApi (

  @SerializedName("leagues" ) var leagues : GameDetailsLeagues? = GameDetailsLeagues()

)