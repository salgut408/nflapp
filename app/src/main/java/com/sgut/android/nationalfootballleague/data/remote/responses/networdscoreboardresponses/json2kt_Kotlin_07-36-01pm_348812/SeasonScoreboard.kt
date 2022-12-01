package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class SeasonScoreboard (

  @SerializedName("year" ) var year : Int?    = null,
//  @SerializedName("type" ) var type : Int?    = null,
  @SerializedName("slug" ) var slug : String? = null

)