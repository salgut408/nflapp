package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteTicketsInfoNetwork(
    @SerializedName("seatSituation")
    val seatSituation: FullAthleteSeatSituationNetwork = FullAthleteSeatSituationNetwork(),
    @SerializedName("tickets")
    val tickets: List<FullAthleteTicketNetwork> = listOf()
)