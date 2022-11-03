package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Stats (

  @SerializedName("name"  ) var name  : String? = null,
  @SerializedName("value" ) var value : Float?    = null

)