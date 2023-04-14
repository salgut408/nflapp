package com.sgut.android.nationalfootballleague.domain.domainmodels.team_stats_models

data class ResultsModel(
    val splits: List<SplitModel> = listOf(),
    val stats: StatsModel = StatsModel()
)