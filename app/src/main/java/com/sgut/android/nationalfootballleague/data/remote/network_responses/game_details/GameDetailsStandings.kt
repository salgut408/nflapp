package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsStandings(

  @SerializedName("fullViewLink")
  val fullViewLink: FullViewLink? = FullViewLink(),
  @SerializedName("groups")
  val groups: List<GameDetailsGroups> = listOf(),

  )