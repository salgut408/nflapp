package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class HomeTeamOdds (

  @SerializedName("favorite"   ) var favorite   : Boolean? = null,
  @SerializedName("underdog"   ) var underdog   : Boolean? = null,
  @SerializedName("moneyLine"  ) var moneyLine  : Float?     = null,
  @SerializedName("spreadOdds" ) var spreadOdds : Float?     = null,
  @SerializedName("teamId"     ) var teamId     : String?  = null

)