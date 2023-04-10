package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.AwayTeamOddsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.HomeTeamOddsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.PickcenterModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.ProviderModel


data class Pickcenter(

  @SerializedName("provider")
  val provider: Provider? = Provider(),
  @SerializedName("details")
  val details: String? = null,
  @SerializedName("overUnder")
  val overUnder: Double? = null,
  @SerializedName("spread")
  val spread: Double? = null,
  @SerializedName("awayTeamOdds")
  val awayTeamOdds: AwayTeamOdds? = AwayTeamOdds(),
  @SerializedName("homeTeamOdds")
  val homeTeamOdds: HomeTeamOdds? = HomeTeamOdds(),

  )

fun Pickcenter.asDomain(): PickcenterModel {
  return PickcenterModel(
    provider = provider?.asDomain() ?: ProviderModel(),
    details = details ?: "",
    overUnder = overUnder ?: 0.0,
    spread = spread ?: 0.0,
    awayTeamOdds = awayTeamOdds?.asDomain() ?: AwayTeamOddsModel(),
    homeTeamOdds = homeTeamOdds?.asDomain() ?: HomeTeamOddsModel()
  )
}