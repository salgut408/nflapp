package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class TicketsInfoModel(
    val tickets: List<TicketModel> = listOf(),
    val seatSituation: SeatSituationModel? = SeatSituationModel(),
)

data class TicketModel(
    val ticketName: String = "",
    val ticketLink: String = "",
    val type: String = ""
)

data class SeatSituationModel(
    val opponentTeamName: String = "",
    val currentTeamName: String = "",
    val venueName: String = "",
    val summary: String = "",
    val date: String = "",
    val dateShort: String = "",
    val dateDay: String = "",
    val homeAway: String = "",
    val eventLink: String = "",
    val venueLink: String = "",
    val genericLink: String = "",
    val teamLink: String = "",
)

