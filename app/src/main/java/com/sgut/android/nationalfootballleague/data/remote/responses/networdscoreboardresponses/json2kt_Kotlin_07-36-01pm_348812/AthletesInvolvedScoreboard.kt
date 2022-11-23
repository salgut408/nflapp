package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class AthletesInvolvedScoreboard (

  @SerializedName("id"          ) var id          : String?          = null,
  @SerializedName("displayName" ) var displayName : String?          = null,
  @SerializedName("shortName"   ) var shortName   : String?          = null,
  @SerializedName("fullName"    ) var fullName    : String?          = null,
  @SerializedName("jersey"      ) var jersey      : String?          = null,
  @SerializedName("team"        ) var team        : Team?            = Team(),
  @SerializedName("links"       ) var links       : ArrayList<LinksScoreboard> = arrayListOf(),
  @SerializedName("position"    ) var position    : String?          = null

)