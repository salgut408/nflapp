package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster

data class RecordItemModel(
    val type: String = "",
    val summary: String = "",
    val stats: List<StatsItemModel>
)
