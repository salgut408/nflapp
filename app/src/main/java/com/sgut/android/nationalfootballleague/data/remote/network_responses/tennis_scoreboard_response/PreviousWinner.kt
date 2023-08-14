package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName

data class PreviousWinner(
    @SerializedName("athletes")
    val athletes: List<AthleteXX> = listOf(),
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("headshot")
    val headshot: String = "",
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = "",
    @SerializedName("type")
    val type: TypeX = TypeX()
)