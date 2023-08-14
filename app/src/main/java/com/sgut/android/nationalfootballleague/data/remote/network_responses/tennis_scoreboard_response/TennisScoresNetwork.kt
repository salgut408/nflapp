package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName

data class TennisScoresNetwork(
    @SerializedName("day")
    val day: Day = Day(),
    @SerializedName("events")
    val events: List<Event> = listOf(),
    @SerializedName("leagues")
    val leagues: List<League> = listOf(),
    @SerializedName("season")
    val season: SeasonXX = SeasonXX()
)