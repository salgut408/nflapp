package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard

// TODO do this for all basics
interface ScoreboardDataInterface{
     val events: List<DefaultEventInterface>
     val league: DefaultLeagueInterface
}



data class DefaultScoreboardModel(
    val league: DefaultLeagueModel = DefaultLeagueModel(),
    val day: String? = "",
    val events: List<DefaultScoreboardEventModel> = listOf(),
    )






