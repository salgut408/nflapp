package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Tracking (

  @SerializedName("sportName"    ) var sportName    : String? = null,
  @SerializedName("leagueName"   ) var leagueName   : String? = null,
  @SerializedName("coverageType" ) var coverageType : String? = null,
  @SerializedName("trackingName" ) var trackingName : String? = null,
  @SerializedName("trackingId"   ) var trackingId   : String? = null

)