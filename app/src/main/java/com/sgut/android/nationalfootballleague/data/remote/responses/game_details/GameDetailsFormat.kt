package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsFormat (

  @SerializedName("regulation" ) var regulation : GameDetailsRegulation? = GameDetailsRegulation(),
  @SerializedName("overtime"   ) var overtime   : GameDetailsOvertime?   = GameDetailsOvertime()

)