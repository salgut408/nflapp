package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsMetrics (

  @SerializedName("count" ) var count : Int?    = null,
  @SerializedName("type"  ) var type  : String? = null

)