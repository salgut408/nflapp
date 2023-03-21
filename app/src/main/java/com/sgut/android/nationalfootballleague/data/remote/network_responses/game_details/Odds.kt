package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Odds (

  @SerializedName("provider"    ) val provider    : Provider?    = Provider(),
  @SerializedName("bettingOdds" ) val bettingOdds : BettingOdds? = BettingOdds()

)