package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class EntriesScoreboard (

  @SerializedName("label"     ) var label     : String? = null,
  @SerializedName("detail"    ) var detail    : String? = null,
  @SerializedName("value"     ) var value     : String? = null,
  @SerializedName("startDate" ) var startDate : String? = null,
  @SerializedName("endDate"   ) var endDate   : String? = null

)