package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class NextEvent3 (

  @SerializedName("id"           ) var id           : String                 = "",
  @SerializedName("date"         ) var date         : String                 = "",
  @SerializedName("name"         ) var name         : String                 = "",
  @SerializedName("shortName"    ) var shortName    : String                 = "",
  @SerializedName("season"       ) var season       : Season3?                 = Season3(),
  @SerializedName("seasonType"   ) var seasonType   : SeasonType3?             = SeasonType3(),
  @SerializedName("week"         ) var week         : Week3?                   = Week3(),
  @SerializedName("timeValid"    ) var timeValid    : Boolean                = false,
  @SerializedName("competitions" ) var competitions : List<Competitions3> = listOf(),
  @SerializedName("links"        ) var links        : List<Links3>        = listOf()

)