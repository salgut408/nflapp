package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class TennisScoreboardResponse(
    val day: Day = Day(),
    val events: List<Event> = listOf(),
    val leagues: List<League> = listOf(),
    val season: SeasonXX = SeasonXX()
)