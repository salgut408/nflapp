package com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule

data class ScheduleVenueModel(
    val address: ScheduleAddressModel = ScheduleAddressModel(),
    val fullName: String = ""
)