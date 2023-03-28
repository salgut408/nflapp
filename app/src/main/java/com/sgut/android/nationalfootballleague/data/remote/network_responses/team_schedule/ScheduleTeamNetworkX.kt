package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName

data class ScheduleTeamNetworkX(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = ""
)