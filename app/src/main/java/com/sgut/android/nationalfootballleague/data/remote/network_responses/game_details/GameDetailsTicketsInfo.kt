package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.TicketsInfoModel


data class GameDetailsTicketsInfo(

  @SerializedName("tickets")
  val tickets: List<GameDetailsTickets> = listOf(),
  @SerializedName("seatSituation")
  val seatSituation: SeatSituation? = SeatSituation(),

  )

fun GameDetailsTicketsInfo.asDomain() : TicketsInfoModel {
  return TicketsInfoModel(
    tickets = tickets.map { it.asDomain() },
    seatSituation = seatSituation?.asDomain()
  )
}