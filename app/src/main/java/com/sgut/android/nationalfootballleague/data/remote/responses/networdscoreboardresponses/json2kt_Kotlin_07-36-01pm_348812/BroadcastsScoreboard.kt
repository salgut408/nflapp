package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class BroadcastsScoreboard (

  @SerializedName("market" ) var market : String?           = null,
  @SerializedName("names"  ) var names  : ArrayList<String> = arrayListOf()

)