package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName

data class Situation(
    @SerializedName("onFirst")
    val onFirst: Boolean = false,
    @SerializedName("onSecond")
    val onSecond: Boolean = false,
    @SerializedName("onThird")
    val onThird: Boolean = false
)