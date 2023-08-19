package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.baseball

data class LastPlayModel(
    val atBatId: String = "",
    val id: String = "",
    val scoreValue: Int = 0,
    val team: TeamModelX = TeamModelX(),
    val text: String = "",
    val type: TypeModelX = TypeModelX()
)