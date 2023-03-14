package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster

data class CompetitionsEventModel(
    val id: String = "",
    val date: String = "",
    val attendance: Int = 0,
    val type: CompetitionTypeModel? = CompetitionTypeModel(),
    val timeValid: Boolean? = null,
    val boxscoreAvailable: Boolean? = null,
    val venue: VenueModel = VenueModel(),
    val competitors: List<CompetitorsModel> = listOf(),
    val notes: List<String> = listOf(),
    val tickets: List<TicketsModel> = listOf(),
    val status: StatusDomainModel? = StatusDomainModel(),

    )
