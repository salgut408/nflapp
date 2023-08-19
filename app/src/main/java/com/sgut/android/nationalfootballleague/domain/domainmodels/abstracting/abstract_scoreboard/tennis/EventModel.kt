package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.tennis

data class EventModel(
    val date: String = "",
    val endDate: String = "",
    val groupings: List<GroupingModel> = listOf(),
    val id: String = "",
    val links: List<LinkModelXX> = listOf(),
    val name: String = "",
    val previousWinners: List<PreviousWinnerModel> = listOf(),
    val season: SeasonModelXX = SeasonModelXX(),
    val shortName: String = "",
    val status: StatusModelX = StatusModelX(),
    val uid: String = "",
    val venue: VenueModelX = VenueModelX()
)