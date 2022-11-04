package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Week3 (

  @SerializedName("number" ) var number : Int?    = null,
  @SerializedName("text"   ) var text   : String? = null

)