package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName

data class ScheduleRecordNetwork(
    @SerializedName("abbreviation")
    val abbreviation: String? = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("displayValue")
    val displayValue: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = "",
    @SerializedName("type")
    val type: String = ""
)