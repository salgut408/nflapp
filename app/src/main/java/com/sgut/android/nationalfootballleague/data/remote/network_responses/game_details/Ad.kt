package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Ad (

  @SerializedName("sport"  )
  val sport  : String = "",
  @SerializedName("bundle" )
  val bundle : String = ""
)