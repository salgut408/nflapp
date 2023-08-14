package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName

data class SeasonXX(
    @SerializedName("type")
    val type: Int = 0,
    @SerializedName("year")
    val year: Int = 0
)