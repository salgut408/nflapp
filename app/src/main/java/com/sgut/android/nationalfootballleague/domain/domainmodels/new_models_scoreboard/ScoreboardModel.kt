package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard

open  class ScoreboardModel(
    val league: EventLeagueModel? = null,
    val day: String? = "",
    val events: List<ScoreboardEventModel> = listOf(),
    )
