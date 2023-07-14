package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class SeasonScoreboard (

  @SerializedName("year" )
  val year : Int    = 0,
//  @SerializedName("type" )
//  val type : Int    = 0,
  @SerializedName("slug" )
  val slug : String = ""

)