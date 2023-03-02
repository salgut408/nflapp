package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Season3 (

  @SerializedName("year"        ) var year        : Int?    = null,
  @SerializedName("displayName" ) var displayName : String? = null

)