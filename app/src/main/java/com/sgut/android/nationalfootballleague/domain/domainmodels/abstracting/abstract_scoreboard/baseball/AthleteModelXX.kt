package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.baseball

data class AthleteModelXX(
    val active: Boolean = false,
    val displayName: String = "",
    val fullName: String = "",
    val headshot: String = "",
    val id: String = "",
    val jersey: String = "",
    val position: PositionModel = PositionModel(),
    val shortName: String = "",
    val team: TeamModelX = TeamModelX()
)