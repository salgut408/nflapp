package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.racing

data class CompetitionModel(
    val broadcasts: List<BroadcastModel> = listOf(),
    val date: String = "",
    val geoBroadcasts: List<GeoBroadcastModel> = listOf(),
    val id: String = "",
    val notes: List<Any> = listOf(),
    val recent: Boolean = false,
    val startDate: String = "",
    val status: StatusModelX = StatusModelX(),
    val timeValid: Boolean = false,
    val type: TypeModelXX = TypeModelXX(),
    val uid: String = ""
)