package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Items (

  @SerializedName("description" ) var description : String?          = null,
  @SerializedName("type"        ) var type        : String?          = null,
  @SerializedName("summary"     ) var summary     : String?          = null,
  @SerializedName("stats"       ) var stats       : List<Stats> = listOf()

)