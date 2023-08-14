package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class League(
    val abbreviation: String = "",
    val calendar: List<String> = listOf(),
    val calendarEndDate: String = "",
    val calendarIsWhitelist: Boolean = false,
    val calendarStartDate: String = "",
    val calendarType: String = "",
    val id: String = "",
    val logos: List<Logo> = listOf(),
    val midsizeName: String = "",
    val name: String = "",
    val season: SeasonX = SeasonX(),
    val slug: String = "",
    val uid: String = ""
)