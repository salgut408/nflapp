package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleFeaturedAthleteModel

data class ScheduleFeaturedAthleteNetwork(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("athlete")
    val athlete: ScheduleAthleteNetwork = ScheduleAthleteNetwork(),
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("playerId")
    val playerId: Int = 0,
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = "",
    @SerializedName("team")
    val team: ScheduleTeamNetworkX = ScheduleTeamNetworkX()
)

fun ScheduleFeaturedAthleteNetwork.asDomain(): ScheduleFeaturedAthleteModel {
    return ScheduleFeaturedAthleteModel(
        abbreviation = abbreviation,
        athlete = athlete.asDomain(),
        displayName = displayName,
        name = name,
        playerId = playerId,
        shortDisplayName = shortDisplayName,
        team = team.asDomain()
    )
}