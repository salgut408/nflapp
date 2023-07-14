package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class AddressScoreboard (

  @SerializedName("city"    ) val city    : String? = null,
  @SerializedName("country" ) val country : String? = null

)