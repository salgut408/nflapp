package com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule

data class ScheduleAthleteModel(
    val displayName: String = "",
    val id: String = "",
    val lastName: String = "",
    val links: List<ScheduleLinkModelX> = listOf(),
    val record: String = "",
    val saves: String = "",
    val shortName: String = ""
)