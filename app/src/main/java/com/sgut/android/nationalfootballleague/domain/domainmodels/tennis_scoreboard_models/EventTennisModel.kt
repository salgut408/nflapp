package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class EventTennisModel(
    val date: String = "",
    val endDate: String = "",
    val groupings: List<GroupingTennisModel> = listOf(),
    val id: String = "",
    val name: String = "",
    val previousWinners: List<PreviousWinnerTennisModel> = listOf(),
    val season: SeasonTennisModelXX = SeasonTennisModelXX(),
    val shortName: String = "",
    val status: StatusTennisModelX = StatusTennisModelX(),
    val uid: String = "",
    val venue: VenueTennisModelX = VenueTennisModelX()
)