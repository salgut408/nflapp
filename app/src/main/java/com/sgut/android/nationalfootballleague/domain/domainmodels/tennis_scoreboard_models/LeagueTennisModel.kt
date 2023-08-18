package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class LeagueTennisModel(
    val abbreviation: String = "",
    val calendar: List<String> = listOf(),
    val calendarEndDate: String = "",
    val calendarIsWhitelist: Boolean = false,
    val calendarStartDate: String = "",
    val calendarType: String = "",
    val id: String = "",
    val logos: List<LogoTennisModel> = listOf(),
    val midsizeName: String = "",
    val name: String = "",
    val season: SeasonTennisModelX = SeasonTennisModelX(),
    val slug: String = "",
    val uid: String = ""
)