package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.tennis

data class CompetitorModel(
    val athlete: AthleteModel = AthleteModel(),
    val curatedRank: CuratedRankModel = CuratedRankModel(),
    val homeAway: String = "",
    val id: String = "",
    val linescores: List<LinescoreModel> = listOf(),
    val order: Int = 0,
    val possession: Boolean = false,
    val roster: RosterModel = RosterModel(),
    val statistics: List<Any> = listOf(),
    val type: String = "",
    val uid: String = "",
    val winner: Boolean = false
)