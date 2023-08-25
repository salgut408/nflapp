package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.football.nfl


import com.google.gson.annotations.SerializedName

data class LeaderX(
    @SerializedName("athlete")
    val athlete: Athlete = Athlete(),
    @SerializedName("displayValue")
    val displayValue: String = "",
    @SerializedName("team")
    val team: TeamXX = TeamXX(),
    @SerializedName("value")
    val value: Double = 0.0
)