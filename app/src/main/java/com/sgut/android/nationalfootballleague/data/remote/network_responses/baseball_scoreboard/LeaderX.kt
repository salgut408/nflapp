package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class LeaderX(
    @SerializedName("athlete")
    val athlete: Athlete? = Athlete(),
    @SerializedName("displayValue")
    val displayValue: String? = "",
    @SerializedName("team")
    val team: TeamX? = TeamX(),
    @SerializedName("value")
    val value: Double? = 0.0
)