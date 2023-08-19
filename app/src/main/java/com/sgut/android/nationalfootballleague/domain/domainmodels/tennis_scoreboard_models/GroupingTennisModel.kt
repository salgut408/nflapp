package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class GroupingTennisModel(
    val competitions: List<TennisCompetitionModel> = listOf(),
    val grouping: GroupingTennisModelX = GroupingTennisModelX()
)
