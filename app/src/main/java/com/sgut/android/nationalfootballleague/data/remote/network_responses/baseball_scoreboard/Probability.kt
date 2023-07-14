package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class Probability(
    @SerializedName("awayWinPercentage")
    val awayWinPercentage: Double? = 0.0,
    @SerializedName("homeWinPercentage")
    val homeWinPercentage: Double? = 0.0,
    @SerializedName("tiePercentage")
    val tiePercentage: Double? = 0.0
)