package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class CalendarScoreboard (

  @SerializedName("label"     ) var label     : String?            = null,
  @SerializedName("startDate" ) var startDate : String?            = null,
  @SerializedName("endDate"   ) var endDate   : String?            = null,
  @SerializedName("entries"   ) var entries   : ArrayList<EntriesScoreboard> = arrayListOf()

)