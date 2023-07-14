package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.HomeTeamOddsModel


data class HomeTeamOdds (

  @SerializedName("favorite"   ) val favorite   : Boolean? = null,
  @SerializedName("underdog"   ) val underdog   : Boolean? = null,
  @SerializedName("moneyLine"  ) val moneyLine  : Float?     = null,
  @SerializedName("spreadOdds" ) val spreadOdds : Float?     = null,
  @SerializedName("teamId"     ) val teamId     : String?  = null

)
fun HomeTeamOdds.asDomain(): HomeTeamOddsModel {
  return HomeTeamOddsModel(
    favorite = favorite ?: false,
    underdog = underdog ?: false,
    moneyLine = moneyLine ?: 0f,
    spreadOdds = spreadOdds ?: 0f,
    teamId = teamId ?: ""
  )
}
