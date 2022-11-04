package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Venue3 (

  @SerializedName("fullName" ) var fullName : String?  = null,
  @SerializedName("address"  ) var address  : Address3? = Address3()


)