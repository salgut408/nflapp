package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Images3 (

  @SerializedName("href"   ) var href   : String?           = null,
  @SerializedName("width"  ) var width  : Int?              = null,
  @SerializedName("height" ) var height : Int?              = null,
  @SerializedName("alt"    ) var alt    : String?           = null,
  @SerializedName("rel"    ) var rel    : List<String> = listOf()

)