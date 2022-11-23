package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class StatisticsScoreboard (

  @SerializedName("name"         ) var name         : String? = null,
  @SerializedName("abbreviation" ) var abbreviation : String? = null,
  @SerializedName("displayValue" ) var displayValue : String? = null

)