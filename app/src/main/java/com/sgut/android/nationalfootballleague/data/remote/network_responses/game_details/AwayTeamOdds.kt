package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.AwayTeamOddsModel


data class AwayTeamOdds(

  @SerializedName("favorite")
  val favorite: Boolean? = null,
  @SerializedName("underdog")
  val underdog: Boolean? = null,
  @SerializedName("moneyLine")
  val moneyLine: Float? = null,
  @SerializedName("spreadOdds")
  val spreadOdds: Float? = null,
  @SerializedName("teamId")
  val teamId: String? = null,

  )
fun AwayTeamOdds.asDomain(): AwayTeamOddsModel {
  return AwayTeamOddsModel(
    favorite = favorite ?: false,
    underdog = underdog ?: false,
    moneyLine = moneyLine ?: 0f,
    spreadOdds = spreadOdds ?: 0f,
    teamId = teamId ?: ""
  )
}