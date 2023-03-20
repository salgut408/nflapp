package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsFormat (

  @SerializedName("regulation" )
  val regulation : GameDetailsRegulation? = GameDetailsRegulation(),
  @SerializedName("overtime"   )
  val overtime   : GameDetailsOvertime?   = GameDetailsOvertime()

)