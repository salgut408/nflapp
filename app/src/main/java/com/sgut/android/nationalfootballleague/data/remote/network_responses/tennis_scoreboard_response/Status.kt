package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("period")
    val period: Int = 0,
    @SerializedName("type")
    val type: Type = Type()
)