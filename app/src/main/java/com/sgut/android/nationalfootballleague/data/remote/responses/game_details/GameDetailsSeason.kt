package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsSeason (

  @SerializedName("year" ) var year : Int? = null,
  @SerializedName("type" ) var type : Int? = null

)