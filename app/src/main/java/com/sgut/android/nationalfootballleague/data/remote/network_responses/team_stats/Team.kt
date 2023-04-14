package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_stats


import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("color")
    val color: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("location")
    val location: String = "",
    @SerializedName("logo")
    val logo: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("recordSummary")
    val recordSummary: String = "",
    @SerializedName("seasonSummary")
    val seasonSummary: String = "",
    @SerializedName("standingSummary")
    val standingSummary: String = ""
)