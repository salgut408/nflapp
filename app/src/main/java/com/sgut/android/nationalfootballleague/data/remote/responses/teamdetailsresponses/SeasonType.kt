package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class SeasonType (

  @SerializedName("id"           ) var id           : String? = null,
  @SerializedName("type"         ) var type         : Int?    = null,
  @SerializedName("name"         ) var name         : String? = null,
  @SerializedName("abbreviation" ) var abbreviation : String? = null

)