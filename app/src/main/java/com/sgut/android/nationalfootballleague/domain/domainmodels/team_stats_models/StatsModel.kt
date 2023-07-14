package com.sgut.android.nationalfootballleague.domain.domainmodels.team_stats_models

data class StatsModel(
    val abbreviation: String = "",
    val categories: List<CategoryModel> = listOf(),
    val id: String = "",
    val name: String = ""
)