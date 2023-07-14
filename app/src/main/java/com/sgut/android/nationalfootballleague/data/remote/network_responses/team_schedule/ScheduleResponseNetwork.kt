package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleDomainModel

data class ScheduleResponseNetwork(
    @SerializedName("allstarsgame")
    val allstarsgame: String = "",
    @SerializedName("events")
    val events: List<ScheduleEventNetwork> = listOf(),
    @SerializedName("requestedSeason")
    val requestedSeason: ScheduleRequestedSeasonNetwork = ScheduleRequestedSeasonNetwork(),
    @SerializedName("season")
    val season: ScheduleSeasonNetworkX = ScheduleSeasonNetworkX(),
    @SerializedName("status")
    val status: String = "",
    @SerializedName("team")
    val team: ScheduleTeamNetworkXX = ScheduleTeamNetworkXX(),
    @SerializedName("timestamp")
    val timestamp: String = ""
)

fun ScheduleResponseNetwork.asDomain(): ScheduleDomainModel {
    return ScheduleDomainModel(
        events = events.map { it.asDomain() },
        season = season.asDomain(),
        team = team.asDomain()
    )
}