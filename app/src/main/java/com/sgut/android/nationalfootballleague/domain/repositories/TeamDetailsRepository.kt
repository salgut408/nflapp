package com.sgut.android.nationalfootballleague.domain.repositories

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsAthleteDetailsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.FullTeamDetailWithRosterModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleDomainModel

interface TeamDetailsRepository {

    suspend fun getSpecificTeam(
        sport: String,
        league: String,
        team: String,
    ): FullTeamDetailWithRosterModel

    suspend fun getSpecificTeamRosterInGameDetails(
        sport: String,
        league: String,
        team: String,
    ): List<GameDetailsAthleteDetailsModel>

    suspend fun getTeamSchedule(
        sport: String,
        league: String,
        teamId: String
    ): ScheduleDomainModel

}