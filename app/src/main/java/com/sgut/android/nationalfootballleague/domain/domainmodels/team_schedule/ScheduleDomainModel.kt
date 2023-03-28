package com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule

data class ScheduleDomainModel(
    val events: List<ScheduleEventModel> = listOf(),
    val season: ScheduleSeasonModelX = ScheduleSeasonModelX(),
    val team: ScheduleTeamModelXX = ScheduleTeamModelXX(),
)