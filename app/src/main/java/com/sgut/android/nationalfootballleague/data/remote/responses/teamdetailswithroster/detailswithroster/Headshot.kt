package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Headshot (

  @SerializedName("href" ) var href : String? = null,
  @SerializedName("alt"  ) var alt  : String? = null

)