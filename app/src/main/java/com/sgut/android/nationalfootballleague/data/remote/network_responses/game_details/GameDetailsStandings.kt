package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsStandings (

  @SerializedName("fullViewLink" ) var fullViewLink : FullViewLink?     = FullViewLink(),
  @SerializedName("groups"       ) var groups       : List<GameDetailsGroups> = listOf()

)