package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Odds (

  @SerializedName("provider"    ) var provider    : Provider?    = Provider(),
  @SerializedName("bettingOdds" ) var bettingOdds : BettingOdds? = BettingOdds()

)