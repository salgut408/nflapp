package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class TimeRestrictions (

  @SerializedName("embargoDate"    ) var embargoDate    : String? = null,
  @SerializedName("expirationDate" ) var expirationDate : String? = null

)