package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("court")
    val court: String = "",
    @SerializedName("fullName")
    val fullName: String = ""
)