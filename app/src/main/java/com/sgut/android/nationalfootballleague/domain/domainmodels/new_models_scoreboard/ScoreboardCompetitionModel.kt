package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard

import com.sgut.android.nationalfootballleague.CompetitorsScoreboard
import com.sgut.android.nationalfootballleague.DetailsScoreboard
import com.sgut.android.nationalfootballleague.FormatScoreboard
import com.sgut.android.nationalfootballleague.HeadlinesScoreboard
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.StatusDomainModel

data class ScoreboardCompetitionModel(
    val id: String = "",
    val uid: String = "",
    val date: String = "",
    val startDate: String = "",
    val attendance: Int = 0,
    val status: StatusDomainModel? = StatusDomainModel(),
    val format: FormatScoreboard? = FormatScoreboard(), // move to own obj
    val competitors: List<CompetitorsScoreboard> = listOf(),// move to own obj
    val details: List<DetailsScoreboard> = listOf(), // move to own obj
    val headlines: List<HeadlinesScoreboard> = listOf(), // move to own obj



    )
