package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName

data class ScheduleTypeNetworkX(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("text")
    val text: String = "",
    @SerializedName("type")
    val type: String = ""
)