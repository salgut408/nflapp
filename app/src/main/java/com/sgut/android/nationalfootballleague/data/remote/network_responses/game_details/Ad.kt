package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Ad (

  @SerializedName("sport"  ) var sport  : String? = null,
  @SerializedName("bundle" ) var bundle : String? = null

)