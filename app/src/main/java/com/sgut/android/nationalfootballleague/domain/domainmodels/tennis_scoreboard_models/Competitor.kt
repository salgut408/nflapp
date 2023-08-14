package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class Competitor(
    val athlete: Athlete = Athlete(),
    val curatedRank: CuratedRank = CuratedRank(),
    val homeAway: String = "",
    val id: String = "",
    val linescores: List<Linescore> = listOf(),
    val order: Int = 0,
    val possession: Boolean = false,
    val roster: Roster = Roster(),
    val statistics: List<Any> = listOf(),
    val type: String = "",
    val uid: String = "",
    val winner: Boolean = false
)