package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class Grouping(
    val competitions: List<Competition> = listOf(),
    val grouping: GroupingX = GroupingX()
)