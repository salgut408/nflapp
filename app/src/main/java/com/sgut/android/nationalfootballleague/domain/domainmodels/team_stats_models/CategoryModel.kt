package com.sgut.android.nationalfootballleague.domain.domainmodels.team_stats_models

data class CategoryModel(
    val abbreviation: String = "",
    val displayName: String = "",
    val name: String = "",
    val stats: List<StatModel> = listOf()
)