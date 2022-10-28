package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Venue (

  @SerializedName("fullName" ) var fullName : String?  = null,
  @SerializedName("address"  ) var address  : Address? = Address()

)