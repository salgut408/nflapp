package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Draft (

  @SerializedName("displayText" ) var displayText : String? = null,
  @SerializedName("round"       ) var round       : Int?    = null,
  @SerializedName("year"        ) var year        : Int?    = null,
  @SerializedName("selection"   ) var selection   : Int?    = null

)