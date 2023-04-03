package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardModel


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

fun NetworkScoreboardResponse.asDomain(): ScoreboardModel {
    return ScoreboardModel(
        league = leagues.get(0).asDomain(),
        day = day?.date ,
        events = events.map { it.asDomain() },
        week = week
    )
}