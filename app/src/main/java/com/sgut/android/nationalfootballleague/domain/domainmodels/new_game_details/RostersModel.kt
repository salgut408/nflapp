package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.TeamModel

data class RostersModel(
    val homeAway: String = "",
    val winner: Boolean = false,
    val team: TeamModel = TeamModel(),
    val roster: List<RosterModel> = listOf(),
)

data class RosterModel(
    val active: Boolean = false,
    val starter: Boolean = false,
    val athlete: GameDetailsAthleteDetailsModel = GameDetailsAthleteDetailsModel(),
    val position: GameDetailsPositionModel = GameDetailsPositionModel(),
    val batOrder: Int = 0,
    val subbedIn: Boolean = false,
    val subbedOut: Boolean = false,
    val stats: List<GameDetailsStatModel> = listOf(),
    var jersey: String = "",
)
