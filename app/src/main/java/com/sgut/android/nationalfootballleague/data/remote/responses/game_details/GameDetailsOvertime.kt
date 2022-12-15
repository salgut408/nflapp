package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsOvertime (

  @SerializedName("periods"     ) var periods     : Int?    = null,
  @SerializedName("displayName" ) var displayName : String? = null,
  @SerializedName("slug"        ) var slug        : String? = null,
  @SerializedName("clock"       ) var clock       : Int?    = null

)