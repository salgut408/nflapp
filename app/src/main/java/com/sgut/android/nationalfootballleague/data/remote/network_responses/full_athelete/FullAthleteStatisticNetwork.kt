package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteStatisticNetwork(
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
    @SerializedName("rank")
    val rank: Int = 0,
    @SerializedName("rankDisplayValue")
    val rankDisplayValue: String = "",
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = "",
    @SerializedName("value")
    val value: Double = 0.0
)