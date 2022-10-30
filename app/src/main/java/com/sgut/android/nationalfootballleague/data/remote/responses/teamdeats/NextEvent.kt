package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class NextEvent (

  @SerializedName("id"           ) var id           : String?                 = null,
  @SerializedName("date"         ) var date         : String?                 = null,
  @SerializedName("name"         ) var name         : String?                 = null,
  @SerializedName("shortName"    ) var shortName    : String?                 = null,
  @SerializedName("season"       ) var season       : Season?                 = Season(),
  @SerializedName("seasonType"   ) var seasonType   : SeasonType?             = SeasonType(),
  @SerializedName("timeValid"    ) var timeValid    : Boolean?                = null,
  @SerializedName("competitions" ) var competitions : List<Competitions> = listOf(),
  @SerializedName("links"        ) var links        : List<Links>        = listOf()

)