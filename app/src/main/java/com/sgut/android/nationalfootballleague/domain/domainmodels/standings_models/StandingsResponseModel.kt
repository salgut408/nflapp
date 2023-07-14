package com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models

data class StandingsResponseModel(
    val displayName: String = "",
    val entries: List<EntryModel> = listOf(),
    val id: String = "",
    val name: String = "",
    val season: Int = 0,
    val seasonType: Int = 0
)