package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName

data class Grouping(
    @SerializedName("competitions")
    val competitions: List<Competition> = listOf(),
    @SerializedName("grouping")
    val grouping: GroupingX = GroupingX()
)