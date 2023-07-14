package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.TeamModel

data class ScoreboardAthleteInvolvedModel(
    val id: String = "",
    val displayName: String = "",
    val shortName: String = "",
    val fullName: String = "",
    val jersey: String = "",
    val team: TeamModel = TeamModel(),
    val position: String = ""
)
