package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class TennisScoreboardModel(
    val day: DayTennisModel = DayTennisModel(),
     val events: List<TennisEventModel> = listOf(),
     val league: LeagueTennisModel = LeagueTennisModel(),
    val season: SeasonTennisModelXX = SeasonTennisModelXX()
)