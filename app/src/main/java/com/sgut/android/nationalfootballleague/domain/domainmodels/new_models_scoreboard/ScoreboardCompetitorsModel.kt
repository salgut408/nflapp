package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard

data class ScoreboardCompetitorsModel(
    val id: String = "",
    val uid: String = "",
    val type: String = "",
    val order: Int = 0,
    val homeAway: String = "",
    val score: String = "",
    val winner: Boolean = false,
    val records: List<ScoreboardRecordModel>,
    val team: ScoreboardTeamModel = ScoreboardTeamModel(),
    val statistics: List<ScoreboardStatisticModel>
)
