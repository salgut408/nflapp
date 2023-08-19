package com.sgut.android.nationalfootballleague.domain.domainmodels.abstracting.abstract_scoreboard.baseball

data class CompetitionModel(
    val attendance: Int = 0,
    val broadcasts: List<BroadcastModel> = listOf(),
    val competitors: List<CompetitorModel> = listOf(),
    val conferenceCompetition: Boolean = false,
    val date: String = "",
    val format: FormatModel = FormatModel(),
    val geoBroadcasts: List<GeoBroadcastModel> = listOf(),
    val headlines: List<HeadlineModel> = listOf(),
    val id: String = "",
    val leaders: List<LeaderModelXX> = listOf(),
    val neutralSite: Boolean = false,
    val notes: List<NoteModel> = listOf(),
    val odds: List<OddModel> = listOf(),
    val outsText: String = "",
    val playByPlayAvailable: Boolean = false,
    val recent: Boolean = false,
    val situation: SituationModel = SituationModel(),
    val startDate: String = "",
    val status: StatusModel = StatusModel(),
    val tickets: List<TicketModel> = listOf(),
    val timeValid: Boolean = false,
    val type: TypeModelXXX = TypeModelXXX(),
    val uid: String = "",
    val venue: VenueModel = VenueModel(),
    val wasSuspended: Boolean = false
)