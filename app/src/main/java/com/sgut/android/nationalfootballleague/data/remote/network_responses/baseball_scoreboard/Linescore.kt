package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class Linescore(
    @SerializedName("value")
    val value: Double? = 0.0
)