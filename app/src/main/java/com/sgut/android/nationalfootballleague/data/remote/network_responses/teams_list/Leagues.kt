package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Leagues (

  @SerializedName("id"           ) var id           : String?          = null,
  @SerializedName("uid"          ) var uid          : String?          = null,
  @SerializedName("name"         ) var name         : String?          = null,
  @SerializedName("abbreviation" ) var abbreviation : String?          = null,
  @SerializedName("shortName"    ) var shortName    : String?          = null,
  @SerializedName("slug"         ) var slug         : String?          = null,
  @SerializedName("teams"        ) var teams        :List<Teams>? = null

)