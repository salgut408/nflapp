package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.racing

data class LeagueModel(
    val abbreviation: String = "",
    val calendar: List<CalendarModel> = listOf(),
    val calendarEndDate: String = "",
    val calendarIsWhitelist: Boolean = false,
    val calendarStartDate: String = "",
    val calendarType: String = "",
    val id: String = "",
    val logos: List<LogoModel> = listOf(),
    val name: String = "",
    val season: SeasonModelX = SeasonModelX(),
    val slug: String = "",
    val uid: String = ""
)