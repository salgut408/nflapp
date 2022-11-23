package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class AddressScoreboard (

  @SerializedName("city"    ) var city    : String? = null,
  @SerializedName("country" ) var country : String? = null

)