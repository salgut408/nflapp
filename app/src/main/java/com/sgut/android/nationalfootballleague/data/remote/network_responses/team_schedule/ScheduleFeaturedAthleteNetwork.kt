package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName

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