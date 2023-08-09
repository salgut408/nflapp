package com.sgut.android.nationalfootballleague.data.repository

import android.util.Log
import com.sgut.android.nationalfootballleague.asDomain
import com.sgut.android.nationalfootballleague.asDomainModel
import com.sgut.android.nationalfootballleague.asGameDetailsAthlete
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.SportsApi
import com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule.asDomain
import com.sgut.android.nationalfootballleague.data.remote.network_responses.team_stats.asDomain
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsAthleteDetailsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.FullTeamDetailWithRosterModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleDomainModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_stats_models.TeamStatsModel
import com.sgut.android.nationalfootballleague.domain.repositories.TeamDetailsRepository
import javax.inject.Inject
//TODO  - - Inject Dispatchers

class TeamDetailsRepositoryImpl @Inject constructor(
    val sportsApi: SportsApi,
    val sportsDataBase: SportsDataBase,
) : TeamDetailsRepository {

    override suspend fun getSpecificTeam(sport: String, league: String, team: String,
    ): FullTeamDetailWithRosterModel {
        try {
            val result = sportsApi.getSpecificTeam(sport, league, team)
            return result.body()?.asDomainModel()?.fullTeam ?: FullTeamDetailWithRosterModel()
        }
        catch (e: Exception) {
            Log.e("SPECIFIC_TEAM", e.cause .toString())
        }
        return sportsApi.getSpecificTeam(sport, league, team).body()?.fullTeam?.asDomain() ?: FullTeamDetailWithRosterModel()
    }

    override suspend fun getSpecificTeamRosterInGameDetails(sport: String, league: String, team: String,
    ): List<GameDetailsAthleteDetailsModel> {
        try {
            val result = sportsApi.getSpecificTeam(sport, league, team).body()?.fullTeam

            return result?.athletes?.map { it.asGameDetailsAthlete() } ?: listOf()
        }
        catch (e: Exception) {
            Log.e("Athletes list err-map", e.stackTraceToString())
        }
        return sportsApi.getSpecificTeam(sport, league, team)
            .body()?.fullTeam?.athletes?.map { it.asGameDetailsAthlete() } ?: listOf()
    }

    override suspend fun getTeamSchedule(sport: String, league: String, teamId: String,
    ): ScheduleDomainModel {
        try {
            val result = sportsApi.getTeamSchedule(sport, league, teamId)
            if (result.isSuccessful) {
                return result.body()?.asDomain() !!
            }
        }
        catch (e: Exception) {
            Log.e("TeamSchedule_ERR", e.stackTrace.toString())
        }
        return sportsApi.getTeamSchedule(sport, league, teamId).body()?.asDomain() ?: ScheduleDomainModel()
    }

    override suspend fun getTeamStats(
        sport: String,
        league: String,
        team: String
    ): TeamStatsModel {
        try {
            val result = sportsApi.getStats(sport, league, team)
            if(result.isSuccessful) {
                Log.e("TEAM_Stats Good", result.toString())

                return result.body()?.asDomain() !!
            }
        } catch (e: Exception) {
            Log.e("TeamStats_ERR", e.message.toString())
        }
        return sportsApi.getStats(sport, league, team).body()?.asDomain() ?: TeamStatsModel()
    }
}