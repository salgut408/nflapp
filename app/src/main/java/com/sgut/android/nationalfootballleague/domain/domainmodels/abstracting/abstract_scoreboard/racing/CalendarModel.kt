package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.racing

data class CalendarModel(
    val endDate: String = "",
    val event: EventModelX = EventModelX(),
    val label: String = "",
    val startDate: String = ""
)