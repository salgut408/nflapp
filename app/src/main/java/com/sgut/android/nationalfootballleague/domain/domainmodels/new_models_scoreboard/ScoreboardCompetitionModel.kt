package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.StatusDomainModel

data class ScoreboardCompetitionModel(
    val id: String = "",
    val uid: String = "",
    val date: String = "",
    val startDate: String = "",
    val attendance: Int = 0,
    val status: StatusDomainModel? = StatusDomainModel(),
    val format: ScoreboardFormatModel = ScoreboardFormatModel(),
    val competitors: List<ScoreboardCompetitorsModel> = listOf(),
    val details: List<ScoreboardDetailsModel> = listOf(),
    val headlines: List<ScoreboardHeadlineModel> = listOf(), // move to own obj
    val venue: ScoreboardVenueModel = ScoreboardVenueModel()
    )
