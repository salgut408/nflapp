package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsTicketsInfo (

  @SerializedName("tickets"       ) var tickets       : ArrayList<GameDetailsTickets> = arrayListOf(),
  @SerializedName("seatSituation" ) var seatSituation : SeatSituation?     = SeatSituation()

)