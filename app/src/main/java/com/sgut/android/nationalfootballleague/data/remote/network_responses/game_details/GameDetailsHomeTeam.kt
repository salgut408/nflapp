package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsHomeTeam (

  @SerializedName("id" ) var id : String? = null,
  @SerializedName("gameProjection" ) var gameProjection : Float? = null,
  @SerializedName("teamChanceLoss" ) var teamChanceLoss : Float? = null,
  @SerializedName("teamChanceTie" ) var teamChanceTie : Float? = null,





  )