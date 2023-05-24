package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName
//TODO MAKE MAODEL
data class BaseballScoreBoardNetwork(
    @SerializedName("day")
    val day: Day? = Day(),
    @SerializedName("events")
    val events: List<Event>? = listOf(),
    @SerializedName("leagues")
    val leagues: List<League>? = listOf(),
    @SerializedName("season")
    val season: SeasonXX? = SeasonXX()
)