package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard

import com.sgut.android.nationalfootballleague.WeekScoreboard

data class ScoreboardModel(
    val leagues: EventLeagueModel? = null,
    val day: String? = "",
    val events: List<ScoreboardEventModel> = listOf(),
    val week: WeekScoreboard = WeekScoreboard(),

    )
