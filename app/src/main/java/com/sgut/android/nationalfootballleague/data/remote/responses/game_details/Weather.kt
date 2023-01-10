package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Weather (

  @SerializedName("temperature"     ) var temperature     : String?    = null,
  @SerializedName("highTemperature" ) var highTemperature : Int?    = null,
  @SerializedName("lowTemperature"  ) var lowTemperature  : Int?    = null,
  @SerializedName("conditionId"     ) var conditionId     : String? = null,
  @SerializedName("gust"            ) var gust            : Int?    = null,
  @SerializedName("precipitation"   ) var precipitation   : Int?    = null,
  @SerializedName("link"            ) var link            : GameDetailsLink?   = GameDetailsLink()

)