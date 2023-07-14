package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class HLS (

  @SerializedName("href" ) var href : String? = null,
  @SerializedName("HD"   ) var HD   : HD?     = HD()

)