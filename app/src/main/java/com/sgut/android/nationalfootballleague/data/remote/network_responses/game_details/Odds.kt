package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.BettingOddsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.OddsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.ProviderModel


data class Odds(

  @SerializedName("provider")
  val provider: Provider? = Provider(),
  @SerializedName("bettingOdds")
  val bettingOdds: BettingOdds? = BettingOdds(),

  )

fun Odds.asDomain(): OddsModel {
  return  OddsModel(
    provider = provider?.asDomain() ?: ProviderModel(),
    bettingOdds = bettingOdds?.asDomain() ?: BettingOddsModel()
  )
}