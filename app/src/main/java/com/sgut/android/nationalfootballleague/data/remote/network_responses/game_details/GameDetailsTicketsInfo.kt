package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsTicketsInfo(

  @SerializedName("tickets") var tickets: List<GameDetailsTickets> = listOf(),
  @SerializedName("seatSituation") var seatSituation: SeatSituation? = SeatSituation(),

  )