package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName

data class SeasonX(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("endDate")
    val endDate: String = "",
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("type")
    val type: TypeXXXX = TypeXXXX(),
    @SerializedName("year")
    val year: Int = 0
)