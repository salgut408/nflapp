package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsImages (

  @SerializedName("name"    ) var name    : String? = null,
  @SerializedName("width"   ) var width   : Int?    = null,
  @SerializedName("alt"     ) var alt     : String? = null,
  @SerializedName("caption" ) var caption : String? = null,
  @SerializedName("url"     ) var url     : String? = null,
  @SerializedName("height"  ) var height  : Int?    = null

)