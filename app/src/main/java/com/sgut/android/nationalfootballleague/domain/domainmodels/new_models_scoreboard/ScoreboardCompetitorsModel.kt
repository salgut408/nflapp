package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard

import com.sgut.android.nationalfootballleague.RecordsScoreboard
import com.sgut.android.nationalfootballleague.StatisticsScoreboard
import com.sgut.android.nationalfootballleague.TeamScoreboard

data class ScoreboardCompetitorsModel(
    val id: String = "",
    val uid: String = "",
    val type: String = "",
    val order: Int = 0,
    val homeAway: String = "",
    val score: String = "",
    val records: List<RecordsScoreboard>, // make mode
    val team: TeamScoreboard = TeamScoreboard(),// make mode
    val statistics: List<StatisticsScoreboard> // make mode
)
