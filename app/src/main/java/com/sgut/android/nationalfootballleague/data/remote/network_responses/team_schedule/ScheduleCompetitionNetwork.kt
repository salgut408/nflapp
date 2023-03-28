package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleCompetitionModel

data class ScheduleCompetitionNetwork(
    @SerializedName("attendance")
    val attendance: Int = 0,
    @SerializedName("boxscoreAvailable")
    val boxscoreAvailable: Boolean = false,
//    @SerializedName("broadcasts")
//    val broadcasts: List<Any> = listOf(),
    @SerializedName("competitors")
    val competitors: List<ScheduleCompetitorNetwork> = listOf(),
    @SerializedName("date")
    val date: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("neutralSite")
    val neutralSite: Boolean = false,
    @SerializedName("notes")
//    val notes: List<Any> = listOf(),
//    @SerializedName("status")
    val status: ScheduleStatusNetwork = ScheduleStatusNetwork(),
    @SerializedName("tickets")
    val tickets: List<ScheduleTicketNetwork>? = listOf(),
    @SerializedName("ticketsAvailable")
    val ticketsAvailable: Boolean = false,
    @SerializedName("timeValid")
    val timeValid: Boolean = false,
    @SerializedName("type")
    val type: ScheduleTypeNetworkX = ScheduleTypeNetworkX(),
    @SerializedName("venue")
    val venue: ScheduleVenueNetwork = ScheduleVenueNetwork()
)

fun ScheduleCompetitionNetwork.asDomain(): ScheduleCompetitionModel {
    return ScheduleCompetitionModel(
        attendance = attendance,
        competitors = competitors.map { it.asDomain() },
        date = date,
        id = id,
        venue = venue.asDomain()
    )
}