package com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models

data class SeasonModel(
    val displayName: String = "",
    val endDate: String = "",
    val startDate: String = "",
    val types: List<TypeModel> = listOf(),
    val year: Int = 0
)