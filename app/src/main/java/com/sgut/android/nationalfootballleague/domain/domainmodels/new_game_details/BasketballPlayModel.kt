package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.TeamModel

data class BasketballPlayModel(
    val id: String = "",
    val text: String = "",
    val awayScore: Int = 0,
    val homeScore: Int = 0,
    val period: Int = 0,
    val clock: String = "",
    val scoringPlay: Boolean = false,
    val scoreValue: Int = 0,
    val team: TeamModel? = TeamModel(),
    val wallclock: String = "",
    val shootingPlay: Boolean = false,
    val coordinate: BasketballCoordinateModel? = BasketballCoordinateModel(),
)


