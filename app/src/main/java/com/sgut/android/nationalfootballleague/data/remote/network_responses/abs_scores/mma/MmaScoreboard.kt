package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.mma


import com.google.gson.annotations.SerializedName

data class MmaScoreboard(
    @SerializedName("events")
    val events: List<Event> = listOf(),
    @SerializedName("leagues")
    val leagues: List<League> = listOf(),
)