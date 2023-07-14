package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class PreMatchTotalHandicap (

  @SerializedName("oddId"      ) var oddId      : String? = null,
  @SerializedName("value"      ) var value      : String? = null,
  @SerializedName("betSlipUrl" ) var betSlipUrl : String? = null

)