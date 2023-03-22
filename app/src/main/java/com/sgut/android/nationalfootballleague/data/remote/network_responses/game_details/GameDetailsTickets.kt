package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.TicketModel


data class GameDetailsTickets(

  @SerializedName("ticketName")
  val ticketName: String? = null,
  @SerializedName("ticketLink")
  val ticketLink: String? = null,
  @SerializedName("type")
  val type: String? = null,

  )

fun GameDetailsTickets.asDomain(): TicketModel {
  return TicketModel(
    ticketName = ticketName ?: "",
    ticketLink = ticketLink ?: "",
    type = type ?: ""
  )
}