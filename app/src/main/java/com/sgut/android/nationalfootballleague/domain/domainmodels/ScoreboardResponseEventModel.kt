package com.sgut.android.nationalfootballleague.domain.domainmodels

import com.sgut.android.nationalfootballleague.*
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardModel

data class ScoreboardResponseEventModel(
    val leagues: List<LeaguesScoreboard> = listOf(),
    val season: SeasonScoreboard? = SeasonScoreboard(),
    val day: DayScoreboard? = DayScoreboard(),
    val events: List<EventsScoreboard> = listOf(),
    val week: WeekScoreboard = WeekScoreboard(),

    )

fun ScoreboardResponseEventModel.asDomain(): ScoreboardModel {
    return ScoreboardModel(
        leagues = leagues.get(0).asDomain(),
        day = day?.date ?: "",
        events = events.map { it.asDomain() },
        week = week
    )
}