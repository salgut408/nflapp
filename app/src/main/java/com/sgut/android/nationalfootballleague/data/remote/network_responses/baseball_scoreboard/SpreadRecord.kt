package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class SpreadRecord(
    @SerializedName("losses")
    val losses: Int? = 0,
    @SerializedName("pushes")
    val pushes: Int? = 0,
    @SerializedName("summary")
    val summary: String? = "",
    @SerializedName("wins")
    val wins: Int? = 0
)