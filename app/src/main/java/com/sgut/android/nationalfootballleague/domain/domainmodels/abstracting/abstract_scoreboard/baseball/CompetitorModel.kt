package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.baseball

data class CompetitorModel(
    val errors: Int = 0,
    val hits: Int = 0,
    val homeAway: String = "",
    val id: String = "",
    val leaders: List<LeaderModel> = listOf(),
    val linescores: List<LinescoreModel> = listOf(),
    val order: Int = 0,
    val probables: List<ProbableModel> = listOf(),
    val records: List<RecordModel> = listOf(),
    val score: String = "",
    val statistics: List<StatisticModelX> = listOf(),
    val team: TeamModelXXX = TeamModelXXX(),
    val type: String = "",
    val uid: String = ""
)