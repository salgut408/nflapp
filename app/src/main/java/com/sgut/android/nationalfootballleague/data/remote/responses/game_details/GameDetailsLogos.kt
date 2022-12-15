package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsLogos (

  @SerializedName("href"        ) var href        : String?           = null,
  @SerializedName("width"       ) var width       : Int?              = null,
  @SerializedName("height"      ) var height      : Int?              = null,
  @SerializedName("alt"         ) var alt         : String?           = null,
  @SerializedName("rel"         ) var rel         : ArrayList<String> = arrayListOf(),
  @SerializedName("lastUpdated" ) var lastUpdated : String?           = null

)