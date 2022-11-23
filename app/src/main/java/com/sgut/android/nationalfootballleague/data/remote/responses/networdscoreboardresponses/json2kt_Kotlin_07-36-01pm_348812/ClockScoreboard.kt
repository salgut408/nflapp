package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class ClockScoreboard (

  @SerializedName("value"        ) var value        : Int?    = null,
  @SerializedName("displayValue" ) var displayValue : String? = null

)