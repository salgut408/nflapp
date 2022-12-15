package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsStatistics (

  @SerializedName("name"         ) var name         : String? = null,
  @SerializedName("displayValue" ) var displayValue : String? = null,
  @SerializedName("label"        ) var label        : String? = null

)