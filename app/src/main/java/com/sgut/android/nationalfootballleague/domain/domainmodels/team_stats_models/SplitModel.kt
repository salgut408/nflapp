package com.sgut.android.nationalfootballleague.domain.domainmodels.team_stats_models

data class SplitModel(
    val abbreviation: String = "",
    val categories: List<CategoryModel> = listOf(),
    val id: Int = 0,
    val name: String = ""
)