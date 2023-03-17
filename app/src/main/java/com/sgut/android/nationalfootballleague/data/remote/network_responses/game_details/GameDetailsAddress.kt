package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


//same as
data class GameDetailsAddress (

  @SerializedName("city"    ) var city    : String? = null,
  @SerializedName("state"   ) var state   : String? = null,
  @SerializedName("zipCode" ) var zipCode : String? = null

)