package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.TeamModel

data class PreviousModel(
    val id: String = "",
    val description: String = "",
    val team: TeamModel? = TeamModel(),
    val timeElapsed: String? = "",
    val yards: Int = 0,
    val isScore: Boolean = false,
    val offensivePlays: Int = 0,
    val result: String = "",
    val shortDisplayResult: String = "",
    val displayResult: String = "",
    val plays: List<FootballPlayModel> = listOf(),
)
