package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class Batter(
    @SerializedName("athlete")
    val athlete: AthleteXXX? = AthleteXXX(),
    @SerializedName("period")
    val period: Int? = 0,
    @SerializedName("playerId")
    val playerId: Int? = 0,
    @SerializedName("summary")
    val summary: String? = ""
)