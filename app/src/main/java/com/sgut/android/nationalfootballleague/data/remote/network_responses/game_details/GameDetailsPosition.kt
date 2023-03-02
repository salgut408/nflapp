package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsPosition (

  @SerializedName("name"         ) var name         : String? = null,
  @SerializedName("displayName"  ) var displayName  : String? = null,
  @SerializedName("abbreviation" ) var abbreviation : String? = null

)