package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class NextEvent3 (

  @SerializedName("id"           ) var id           : String?                 = null,
  @SerializedName("date"         ) var date         : String?                 = null,
  @SerializedName("name"         ) var name         : String?                 = null,
  @SerializedName("shortName"    ) var shortName    : String?                 = null,
  @SerializedName("season"       ) var season       : Season3?                 = Season3(),
  @SerializedName("seasonType"   ) var seasonType   : SeasonType3?             = SeasonType3(),
  @SerializedName("week"         ) var week         : Week3?                   = Week3(),
  @SerializedName("timeValid"    ) var timeValid    : Boolean?                = null,
  @SerializedName("competitions" ) var competitions : List<Competitions3> = listOf(),
  @SerializedName("links"        ) var links        : List<Links3>        = listOf()

)