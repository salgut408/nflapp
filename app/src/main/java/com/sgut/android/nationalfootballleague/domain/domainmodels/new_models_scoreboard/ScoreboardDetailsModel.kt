package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.CompetitionTypeModel

data class ScoreboardDetailsModel(
    val type: CompetitionTypeModel?,
    val clock: ScoreboardClockModel? = ScoreboardClockModel(),
    val team: ScoreboardTeamModel = ScoreboardTeamModel(),
    val scoreValue: Int = 0,
    val scoringPlay: Boolean = false,
    val redCard: Boolean? = null,
    val yellowCard: Boolean? = null,
    val penaltyKick: Boolean? = null,
    val ownGoal: Boolean? = null,
    val shootout: Boolean? = null,
    val athletesInvolved: List<ScoreboardAthleteInvolvedModel> = listOf(),


    )
