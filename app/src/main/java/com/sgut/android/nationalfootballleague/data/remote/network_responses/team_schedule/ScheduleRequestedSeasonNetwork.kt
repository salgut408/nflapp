package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName

data class ScheduleRequestedSeasonNetwork(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("type")
    val type: Int = 0,
    @SerializedName("year")
    val year: Int = 0
)