package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsAthlete (

  @SerializedName("id"          ) var id          : String?          = null,
  @SerializedName("uid"         ) var uid         : String?          = null,
  @SerializedName("guid"        ) var guid        : String?          = null,
  @SerializedName("lastName"    ) var lastName    : String?          = null,
  @SerializedName("fullName"    ) var fullName    : String?          = null,
  @SerializedName("displayName" ) var displayName : String?          = null,
  @SerializedName("shortName"   ) var shortName   : String?          = null,
  @SerializedName("links"       ) var links       : ArrayList<GameDetailsLinks> = arrayListOf(),
  @SerializedName("headshot"    ) var headshot    : GameDetailsHeadshot?        = GameDetailsHeadshot(),
  @SerializedName("jersey"      ) var jersey      : String?          = null,
  @SerializedName("position"    ) var position    : GameDetailsPosition?        = GameDetailsPosition()

)