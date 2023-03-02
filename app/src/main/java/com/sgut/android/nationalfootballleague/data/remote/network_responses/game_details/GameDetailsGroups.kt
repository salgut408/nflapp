package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsGroups (

  @SerializedName("standings" ) var standings : GameDetailsStandings? = GameDetailsStandings(),
  @SerializedName("header"    ) var header    : String?    = null,
  @SerializedName("href"      ) var href      : String?    = null

)