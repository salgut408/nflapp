package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class Event(
    val date: String = "",
    val endDate: String = "",
    val groupings: List<Grouping> = listOf(),
    val id: String = "",
    val links: List<LinkXX> = listOf(),
    val name: String = "",
    val previousWinners: List<PreviousWinner> = listOf(),
    val season: SeasonX = SeasonX(),
    val shortName: String = "",
    val status: StatusX = StatusX(),
    val uid: String = "",
    val venue: VenueX = VenueX()
)