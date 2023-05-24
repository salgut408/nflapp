package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class SeasonXX(
    @SerializedName("type")
    val type: Int? = 0,
    @SerializedName("year")
    val year: Int? = 0
)