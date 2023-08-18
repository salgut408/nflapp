package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class GroupingTennisModel(
    val competitions: List<CompetitionTennisModel> = listOf(),
    val grouping: GroupingTennisModelX = GroupingTennisModelX()
)