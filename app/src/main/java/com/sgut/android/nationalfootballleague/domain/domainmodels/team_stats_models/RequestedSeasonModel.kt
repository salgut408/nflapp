package com.sgut.android.nationalfootballleague.domain.domainmodels.team_stats_models

data class RequestedSeasonModel(
    val displayName: String = "",
    val name: String = "",
    val qualifiedPostSeason: Boolean = false,
    val type: Int = 0,
    val year: Int = 0
)