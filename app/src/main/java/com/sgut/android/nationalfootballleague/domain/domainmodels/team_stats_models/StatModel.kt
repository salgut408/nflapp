package com.sgut.android.nationalfootballleague.domain.domainmodels.team_stats_models

data class StatModel(
    val abbreviation: String = "",
    val description: String = "",
    val displayName: String = "",
    val displayValue: String = "",
    val name: String = "",
    val shortDisplayName: String = "",
    val value: Double = 0.0
)