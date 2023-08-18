package com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models

data class CompetitionTennisModel(
    val competitors: List<CompetitorTennisModel> = listOf(),
    val date: String = "",
    val format: FormatTennisModel = FormatTennisModel(),
    val id: String = "",
    val major: Boolean = false,
    val notes: List<NoteTennisModel> = listOf(),
    val recent: Boolean = false,
    val round: RoundTennisModel = RoundTennisModel(),
    val situation: SituationTennisModel = SituationTennisModel(),
    val startDate: String = "",
    val status: StatusTennisModel = StatusTennisModel(),
    val timeValid: Boolean = false,
    val tournamentId: Int = 0,
    val type: TypeTennisModelX = TypeTennisModelX(),
    val uid: String = "",
    val venue: VenueTennisModel = VenueTennisModel(),
    val wasSuspended: Boolean = false
)