package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster

data class CompetitorsModel(
    val id: String = "",
    val type: String = "",
    val order: Int = 0,
    val homeAway: String = "",
    val team: FullTeamDetailWithRosterModel? = FullTeamDetailWithRosterModel(),

    )
