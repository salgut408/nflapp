package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Logos (

  @SerializedName("href"   ) var href   : String?           = null,
  @SerializedName("alt"    ) var alt    : String?           = null,
  @SerializedName("rel"    ) var rel    : ArrayList<String> = arrayListOf(),
  @SerializedName("width"  ) var width  : Int?              = null,
  @SerializedName("height" ) var height : Int?              = null

)