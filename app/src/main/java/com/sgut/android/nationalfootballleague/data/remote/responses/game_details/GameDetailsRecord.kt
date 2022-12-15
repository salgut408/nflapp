package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsRecord (

  @SerializedName("type"         ) var type         : String? = null,
  @SerializedName("summary"      ) var summary      : String? = null,
  @SerializedName("displayValue" ) var displayValue : String? = null

)