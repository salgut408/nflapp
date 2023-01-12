package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsEntries (

  @SerializedName("team"  ) var team  : String?          = null,
  @SerializedName("link"  ) var link  : String?          = null,
  @SerializedName("id"    ) var id    : String?          = null,
  @SerializedName("uid"   ) var uid   : String?          = null,
  @SerializedName("stats" ) var stats : List<GameDetailsStats> = listOf(),
  @SerializedName("logo"  ) var logo  : List<GameDetailsLogo>  = listOf()

)