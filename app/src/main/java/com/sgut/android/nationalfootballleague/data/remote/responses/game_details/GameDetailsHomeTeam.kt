package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsHomeTeam (

  @SerializedName("id" ) var id : String? = null,
  @SerializedName("gameProjection" ) var gameProjection : String? = null,
  @SerializedName("teamChanceLoss" ) var teamChanceLoss : String? = null,
  @SerializedName("teamChanceTie" ) var teamChanceTie : String? = null,





  )