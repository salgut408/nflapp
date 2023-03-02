package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Items3 (

  @SerializedName("type"    ) var type    : String?          = null,
  @SerializedName("summary" ) var summary : String?          = null,
  @SerializedName("stats"   ) var stats   : List<Stats3?> = listOf()

)