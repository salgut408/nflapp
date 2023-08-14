package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName

data class Roster(
    @SerializedName("athletes")
    val athletes: List<AthleteX> = listOf(),
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = ""
)