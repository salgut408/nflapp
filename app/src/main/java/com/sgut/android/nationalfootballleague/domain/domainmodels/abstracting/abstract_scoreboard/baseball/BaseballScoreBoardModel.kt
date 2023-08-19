package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.baseball

data class BaseballScoreBoardModel(
    val day: DayModel = DayModel(),
    val events: List<EventModel> = listOf(),
    val leagues: List<LeagueModel> = listOf(),
    val season: SeasonModelXX = SeasonModelXX()
)