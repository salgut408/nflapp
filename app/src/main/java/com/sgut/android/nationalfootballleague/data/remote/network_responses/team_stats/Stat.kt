package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_stats


import com.google.gson.annotations.SerializedName

data class Stat(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("displayValue")
    val displayValue: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = "",
    @SerializedName("value")
    val value: Double = 0.0
)