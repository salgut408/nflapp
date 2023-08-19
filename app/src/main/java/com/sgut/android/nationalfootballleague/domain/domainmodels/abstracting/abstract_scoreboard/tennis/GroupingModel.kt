package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.tennis

data class GroupingModel(
    val competitions: List<CompetitionModel> = listOf(),
    val grouping: GroupingModelX = GroupingModelX()
)