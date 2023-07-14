package com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.EventScoreboard

data class Seasonseries(
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("summary")
    val summary: String? = null,
    @SerializedName("completed")
    val completed: Boolean? = null,
    @SerializedName("totalCompetitions")
    val totalCompetitions: Int? = null,
    @SerializedName("events")
    val events: List<EventScoreboard> = listOf(),
)
