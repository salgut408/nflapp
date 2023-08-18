package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class ScoreboardTennisModel(
    val day: DayTennisModel = DayTennisModel(),
    val events: List<EventTennisModel> = listOf(),
    val league:LeagueTennisModel = LeagueTennisModel(),
    val season: SeasonTennisModelXX = SeasonTennisModelXX()
)