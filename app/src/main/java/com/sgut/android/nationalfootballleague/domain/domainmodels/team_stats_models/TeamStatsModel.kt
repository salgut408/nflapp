package com.sgut.android.nationalfootballleague.domain.domainmodels.team_stats_models

data class TeamStatsModel(
    val results: ResultsModel = ResultsModel(),
    val season: SeasonModel = SeasonModel(),
    val team: TeamModel = TeamModel()
)