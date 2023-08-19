package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.racing

data class EventModel(
    val circuit: CircuitModel = CircuitModel(),
    val competitions: List<CompetitionModel> = listOf(),
    val date: String = "",
    val endDate: String = "",
    val id: String = "",
    val links: List<LinkModel> = listOf(),
    val name: String = "",
    val season: SeasonModel = SeasonModel(),
    val shortName: String = "",
    val status: StatusModelX = StatusModelX(),
    val uid: String = ""
)