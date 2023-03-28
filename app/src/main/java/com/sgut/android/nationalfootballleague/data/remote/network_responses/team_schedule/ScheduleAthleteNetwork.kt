package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName

data class ScheduleAthleteNetwork(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("lastName")
    val lastName: String = "",
    @SerializedName("links")
    val links: List<ScheduleLinkNetworkX> = listOf(),
    @SerializedName("record")
    val record: String = "",
    @SerializedName("saves")
    val saves: String = "",
    @SerializedName("shortName")
    val shortName: String = ""
)