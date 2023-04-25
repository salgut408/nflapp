package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class TicketsInfo(
    @SerializedName("seatSituation")
    val seatSituation: SeatSituation = SeatSituation(),
    @SerializedName("tickets")
    val tickets: List<Ticket> = listOf()
)