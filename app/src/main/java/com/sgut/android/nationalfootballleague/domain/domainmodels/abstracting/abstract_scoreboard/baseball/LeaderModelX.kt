package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.baseball

data class LeaderModelX(
    val athlete: AthleteModel = AthleteModel(),
    val displayValue: String = "",
    val team: TeamModelX = TeamModelX(),
    val value: Double = 0.0
)