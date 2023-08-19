package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.baseball

data class LeaderModel(
    val abbreviation: String = "",
    val displayName: String = "",
    val leaders: List<LeaderModelX> = listOf(),
    val name: String = "",
    val shortDisplayName: String = ""
)