package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.baseball


import com.google.gson.annotations.SerializedName

data class LeaderXXX(
    @SerializedName("athlete")
    val athlete: AthleteXX = AthleteXX(),
    @SerializedName("displayValue")
    val displayValue: String = "",
    @SerializedName("team")
    val team: TeamX = TeamX(),
    @SerializedName("value")
    val value: Double = 0.0
)