package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsStatus(

  @SerializedName("type") var type: GameDetailsType? = GameDetailsType(),


  )