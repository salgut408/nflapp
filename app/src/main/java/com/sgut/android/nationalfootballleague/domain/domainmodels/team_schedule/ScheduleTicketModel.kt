package com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule

data class ScheduleTicketModel(
    val description: String = "",
    val id: String = "",
    val links: List<ScheduleLinkModelX> = listOf(),
    val maxPrice: Double = 0.0,
    val numberAvailable: Int = 0,
    val startingPrice: Double = 0.0,
    val summary: String = "",
    val totalPostings: Int = 0
)