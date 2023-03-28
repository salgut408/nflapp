package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleEventModel

data class ScheduleEventNetwork(
    @SerializedName("competitions")
    val competitions: List<ScheduleCompetitionNetwork> = listOf(),
    @SerializedName("date")
    val date: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("links")
    val links: List<ScheduleLinkNetworkXXX> = listOf(),
    @SerializedName("name")
    val name: String = "",
    @SerializedName("season")
    val season: ScheduleSeasonNetwork = ScheduleSeasonNetwork(),
    @SerializedName("seasonType")
    val seasonType: ScheduleSeasonTypeNetwork = ScheduleSeasonTypeNetwork(),
    @SerializedName("shortName")
    val shortName: String = "",
    @SerializedName("timeValid")
    val timeValid: Boolean = false
)

fun ScheduleEventNetwork.asDomain(): ScheduleEventModel {
    return ScheduleEventModel(
        competitions = competitions.map { it.asDomain() },
        date = date,
        id = id,
        name = name,
        shortName = shortName
    )
}