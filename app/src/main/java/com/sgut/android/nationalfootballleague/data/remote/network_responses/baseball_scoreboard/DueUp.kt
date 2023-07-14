package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class DueUp(
    @SerializedName("athlete")
    val athlete: AthleteXXXX? = AthleteXXXX(),
    @SerializedName("batOrder")
    val batOrder: Int? = 0,
    @SerializedName("period")
    val period: Int? = 0,
    @SerializedName("playerId")
    val playerId: Int? = 0,
    @SerializedName("summary")
    val summary: String? = ""
)