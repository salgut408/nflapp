package com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule

data class ScheduleStatusModel(
    val clock: Double = 0.0,
    val displayClock: String = "",
    val featuredAthletes: List<ScheduleFeaturedAthleteModel>? = listOf(),
    val halfInning: Int = 0,
    val period: Int = 0,
    val periodPrefix: String = "",
    val type: ScheduleTypeModel = ScheduleTypeModel()
)