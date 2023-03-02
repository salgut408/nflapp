package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class StatusScoreboard(
  @SerializedName("clock") var clock: String? = null,
  @SerializedName("displayClock") var displayClock: String? = null,
  @SerializedName("period") var period: Int = 0,
  @SerializedName("type") var type: TypeScoreboard? = TypeScoreboard(),
  )