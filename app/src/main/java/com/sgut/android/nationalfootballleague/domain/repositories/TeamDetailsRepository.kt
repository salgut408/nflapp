package com.sgut.android.nationalfootballleague.domain.repositories

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.FullTeamDetailWithRosterModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.TeamScheduleModel

interface TeamDetailsRepository {

    suspend fun getSpecificTeam(
        sport: String,
        league: String,
        team: String,
    ): FullTeamDetailWithRosterModel

    suspend fun getTeamSchedule(
        sport: String,
        league: String,
        teamId: Int
    ): TeamScheduleModel

}