package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Default (

  @SerializedName("href"   ) var href   : String? = null,
  @SerializedName("width"  ) var width  : Int?    = null,
  @SerializedName("height" ) var height : Int?    = null

)