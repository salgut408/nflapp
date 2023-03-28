package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName

data class ScheduleScoreNetwork(
    @SerializedName("displayValue")
    val displayValue: String = "",
    @SerializedName("value")
    val value: Double = 0.0
)