package com.sgut.android.nationalfootballleague.data.repository

import android.util.Log
import com.sgut.android.nationalfootballleague.asDomainModel
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.EspnApi
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models.FullTeamsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models.LeagueModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models.SportModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models.TeamModel
import com.sgut.android.nationalfootballleague.domain.repositories.TeamsListsRepository
import com.sgut.android.nationalfootballleague.toDomain
import javax.inject.Inject

class TeamsListRepositoryImpl @Inject constructor(
   val espnApi: EspnApi,
   val sportsDataBase: SportsDataBase
): TeamsListsRepository {
    override suspend fun getFullSportLeagueAndTeamsList(sport: String, league: String): FullTeamsModel {
        val result = espnApi.getTeamsListForLeague(sport, league).body()?.toDomain()!!
        Log.e("TEAMREPO", result.toString())
        return result
    }

    override suspend fun getSport(sport: String, league: String): SportModel {
        val result = espnApi.getTeamsListForLeague(sport, league).body()?.sports?.get(0)?.toDomain()!!
        return result
    }

    override suspend fun getLeague(sport: String, league: String): LeagueModel {
        val result = espnApi.getTeamsListForLeague(sport, league).body()?.sports?.get(0)?.leagues?.get(0)?.toDomain()!!
        return result
    }

    override suspend fun getTeamsList(sport: String, league: String): List<TeamModel> {
        val result = espnApi.getTeamsListForLeague(sport, league).body()?.sports?.get(0)?.leagues?.get(0)?.teams?.map { it.teamSingle.asDomainModel() }!!
    return result
    }


}