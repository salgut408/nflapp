package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.baseball

data class LeagueModel(
    val abbreviation: String = "",
    val calendar: List<String> = listOf(),
    val calendarEndDate: String = "",
    val calendarIsWhitelist: Boolean = false,
    val calendarStartDate: String = "",
    val calendarType: String = "",
    val id: String = "",
    val logos: List<LogoModel> = listOf(),
    val midsizeName: String = "",
    val name: String = "",
    val season: SeasonModelX = SeasonModelX(),
    val slug: String = "",
    val uid: String = ""
)