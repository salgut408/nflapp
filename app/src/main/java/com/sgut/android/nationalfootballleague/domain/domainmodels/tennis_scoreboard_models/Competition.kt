package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class Competition(
    val broadcasts: List<Any> = listOf(),
    val competitors: List<Competitor> = listOf(),
    val date: String = "",
    val format: Format = Format(),
    val geoBroadcasts: List<Any> = listOf(),
    val id: String = "",
    val major: Boolean = false,
    val notes: List<Note> = listOf(),
    val recent: Boolean = false,
    val round: Round = Round(),
    val situation: Situation = Situation(),
    val startDate: String = "",
    val status: Status = Status(),
    val timeValid: Boolean = false,
    val tournamentId: Int = 0,
    val type: TypeX = TypeX(),
    val uid: String = "",
    val venue: Venue = Venue(),
    val wasSuspended: Boolean = false
)