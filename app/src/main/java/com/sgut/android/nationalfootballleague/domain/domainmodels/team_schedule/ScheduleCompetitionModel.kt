package com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule

data class ScheduleCompetitionModel(
    val attendance: Int = 0,
    val competitors: List<ScheduleCompetitorModel> = listOf(),
    val date: String = "",
    val id: String = "",
    val venue: ScheduleVenueModel = ScheduleVenueModel()
)