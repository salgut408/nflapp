package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.tennis

data class CompetitionModel(
    val broadcasts: List<Any> = listOf(),
    val competitors: List<CompetitorModel> = listOf(),
    val date: String = "",
    val format: FormatModel = FormatModel(),
    val geoBroadcasts: List<Any> = listOf(),
    val id: String = "",
    val major: Boolean = false,
    val notes: List<NoteModel> = listOf(),
    val recent: Boolean = false,
    val round: RoundModel = RoundModel(),
    val situation: SituationModel = SituationModel(),
    val startDate: String = "",
    val status: StatusModel = StatusModel(),
    val timeValid: Boolean = false,
    val tournamentId: Int = 0,
    val type: TypeModelX = TypeModelX(),
    val uid: String = "",
    val venue: VenueModel = VenueModel(),
    val wasSuspended: Boolean = false
)