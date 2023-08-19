package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.baseball

data class EventModel(
    val competitions: List<CompetitionModel> = listOf(),
    val date: String = "",
    val id: String = "",
    val links: List<LinkModelXXXXXX> = listOf(),
    val name: String = "",
    val season: SeasonModel = SeasonModel(),
    val shortName: String = "",
    val status: StatusModelX = StatusModelX(),
    val uid: String = "",
    val weather: WeatherModel = WeatherModel()
)