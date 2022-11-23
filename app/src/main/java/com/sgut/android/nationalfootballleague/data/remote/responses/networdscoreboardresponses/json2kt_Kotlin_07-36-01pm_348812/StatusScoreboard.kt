package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class StatusScoreboard (

  @SerializedName("clock"        ) var clock        : Int?    = null,
  @SerializedName("displayClock" ) var displayClock : String? = null,
  @SerializedName("period"       ) var period       : Int?    = null,
  @SerializedName("type"         ) var type         : TypeScoreboard?   = TypeScoreboard()

)