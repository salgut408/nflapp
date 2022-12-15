package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsType (

  @SerializedName("id"        ) var id        : String? = null,
  @SerializedName("shortName" ) var shortName : String? = null

)