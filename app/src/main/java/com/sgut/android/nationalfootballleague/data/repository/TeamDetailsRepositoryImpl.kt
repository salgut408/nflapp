package com.sgut.android.nationalfootballleague.data.repository

import android.util.Log
import com.sgut.android.nationalfootballleague.asDomain
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.EspnApi
import com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule.asDomain
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.FullTeamDetailWithRosterModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleDomainModel
import com.sgut.android.nationalfootballleague.domain.repositories.TeamDetailsRepository
import javax.inject.Inject

class TeamDetailsRepositoryImpl @Inject constructor(
    val espnApi: EspnApi,
    val sportsDataBase: SportsDataBase
): TeamDetailsRepository{

    override suspend fun getSpecificTeam(
        sport: String,
        league: String,
        team: String,
    ): FullTeamDetailWithRosterModel {
//      TODO fix certain teams being null @ request for team details screen

        val result = espnApi.getSpecificTeam(sport, league, team).body()?.fullTeam
        return result?.asDomain() ?:  FullTeamDetailWithRosterModel()
    }

    override suspend fun getTeamSchedule(
        sport: String,
        league: String,
        teamId: String,
    ): ScheduleDomainModel {
        try {
            val result = espnApi.getTeamSchedule(sport, league, teamId).body()
            Log.e("SCHEDULE_REPOS", result?.team.toString())

            return result?.asDomain() ?: ScheduleDomainModel()

        } catch (e: Exception) {
            Log.e("SCHEDULE ERR", e.toString())
        }

        val result = espnApi.getTeamSchedule(sport, league, teamId).body()
//        Log.e("SCHEDULE_REPOS", result.toString())
//
        return result?.asDomain() ?: ScheduleDomainModel()
    }


}