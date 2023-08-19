package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.baseball

data class SituationModel(
    val balls: Int = 0,
    val dueUp: List<DueUpModel> = listOf(),
    val lastPlay: LastPlayModel = LastPlayModel(),
    val onFirst: Boolean = false,
    val onSecond: Boolean = false,
    val onThird: Boolean = false,
    val outs: Int = 0,
    val strikes: Int = 0
)