package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class TeamScoreboard (

  @SerializedName("id" ) var id : String = "",
  @SerializedName("abbreviation" ) var abbreviation : String = "",
  @SerializedName("name" ) var name : String = "",
  @SerializedName("logo"            ) var logo            : String = "",
  @SerializedName("color"            ) var color            : String          = "",
  @SerializedName("displayName"            ) var displayName            : String          = "",
  @SerializedName("score"            ) var score            : Int          = 0,
  @SerializedName("shortDisplayName"            ) var shortDisplayName            : String          = "",







  )