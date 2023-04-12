package com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models

data class EntryModel(
    val stats: List<StatModel> = listOf(),
    val team: TeamModel = TeamModel()
)