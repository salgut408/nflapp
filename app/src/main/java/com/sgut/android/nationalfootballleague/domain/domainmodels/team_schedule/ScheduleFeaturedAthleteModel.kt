package com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule

data class ScheduleFeaturedAthleteModel(
    val abbreviation: String = "",
    val athlete: ScheduleAthleteModel = ScheduleAthleteModel(),
    val displayName: String = "",
    val name: String = "",
    val playerId: Int = 0,
    val shortDisplayName: String = "",
    val team: ScheduleTeamModelX = ScheduleTeamModelX()
)