package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.soccer


import com.google.gson.annotations.SerializedName

data class SoccerScoreboard(
    @SerializedName("events")
    val events: List<Event> = listOf(),
    @SerializedName("leagues")
    val leagues: List<League> = listOf(),

)