package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class RecordsScoreboard (

  @SerializedName("name"         ) var name         : String? = null,
  @SerializedName("type"         ) var type         : String? = null,
  @SerializedName("summary"      ) var summary      : String? = null,
  @SerializedName("abbreviation" ) var abbreviation : String? = null

)