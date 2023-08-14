package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName

data class AthleteX(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("fullName")
    val fullName: String = "",
    @SerializedName("guid")
    val guid: String = "",
    @SerializedName("links")
    val links: List<LinkXX> = listOf(),
    @SerializedName("shortName")
    val shortName: String = ""
)