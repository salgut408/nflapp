package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class NetworkScoreboardResponse(
    @SerializedName("leagues")
    val leagues: List<LeaguesScoreboard> = listOf(),

    @SerializedName("season")
    val season: SeasonScoreboard? = SeasonScoreboard(),

    @SerializedName("day")
    val day: DayScoreboard? = DayScoreboard(),

    @SerializedName("events")
    val events: List<EventsScoreboard> = listOf(),

    @SerializedName("week")
    val week: WeekScoreboard = WeekScoreboard(),
    )

data class WeekScoreboard(
    @SerializedName("number") var week: Int = 0,

    )