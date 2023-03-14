package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster

data class CompetitionStatusModel(
    val clock: Int = 0,
    val displayClock: String = "",
    val period: Int = 0,
    val type: CompetitionTypeModel? = CompetitionTypeModel(),

    )
