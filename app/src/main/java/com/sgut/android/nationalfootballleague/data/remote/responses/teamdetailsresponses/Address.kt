package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Address (

  @SerializedName("city"  ) var city  : String? = null,
  @SerializedName("state" ) var state : String? = null

)