package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.baseball

data class ProbableModel(
    val abbreviation: String = "",
    val athlete: AthleteModelX = AthleteModelX(),
    val displayName: String = "",
    val name: String = "",
    val playerId: Int = 0,
    val shortDisplayName: String = "",
    val statistics: List<StatisticModelX> = listOf()
)