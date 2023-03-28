package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName

data class ScheduleSeasonNetwork(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("year")
    val year: Int = 0
)