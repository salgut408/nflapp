package com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule

data class ScheduleCompetitorModel(
    val homeAway: String = "",
    val id: String = "",
    val score: ScheduleScoreModel? = ScheduleScoreModel(),
    val team: ScheduleTeamModel = ScheduleTeamModel(),
    val winner: Boolean? = false
)