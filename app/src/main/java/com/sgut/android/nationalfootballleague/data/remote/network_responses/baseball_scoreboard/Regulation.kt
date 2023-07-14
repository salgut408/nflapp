package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class Regulation(
    @SerializedName("periods")
    val periods: Int? = 0
)