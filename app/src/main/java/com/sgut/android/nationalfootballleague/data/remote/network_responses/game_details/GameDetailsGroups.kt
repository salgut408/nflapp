package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsGroups(

  @SerializedName("standings")
  val standings: GameDetailsStandings? = GameDetailsStandings(),
  @SerializedName("header")
  val header: String? = null,
  @SerializedName("href")
  val href: String? = null,

  )