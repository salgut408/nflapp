package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsOpponent (

  @SerializedName("id"           ) var id           : String?          = null,
  @SerializedName("uid"          ) var uid          : String?          = null,
  @SerializedName("displayName"  ) var displayName  : String?          = null,
  @SerializedName("abbreviation" ) var abbreviation : String?          = null,
  @SerializedName("links"        ) var links        : ArrayList<GameDetailsLinks> = arrayListOf(),
  @SerializedName("logo"         ) var logo         : String?          = null

)