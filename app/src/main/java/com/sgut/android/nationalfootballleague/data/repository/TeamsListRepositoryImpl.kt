package com.sgut.android.nationalfootballleague.data.repository

import android.util.Log
import com.sgut.android.nationalfootballleague.asDomainModel
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.SportsApi
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.*
import com.sgut.android.nationalfootballleague.domain.repositories.TeamsListsRepository
import com.sgut.android.nationalfootballleague.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

// interatcs and gets sports id, league id
class TeamsListRepositoryImpl @Inject constructor(
    val sportsApi: SportsApi,
    val sportsDataBase: SportsDataBase,
) : TeamsListsRepository {

    override suspend fun getFullSportLeagueAndTeamsList(
        sport: String,
        league: String,
    ): FullTeamsListsModel {
        try {
            val result = sportsApi.getTeamsListForLeague(sport, league).body()?.toDomain()!!
            return result
        } catch (e: Exception) {
            Log.e("LISTS", e.message.toString())
        }
        val result = sportsApi.getTeamsListForLeague(sport, league).body()?.toDomain()!!
        return result
    }

    override suspend fun getSport(sport: String, league: String): SportModel {
        val result =
            sportsApi.getTeamsListForLeague(sport, league).body()?.sports?.get(0)?.toDomain()!!
        return result
    }

    override suspend fun getLeague(sport: String, league: String): LeagueModel {
        val result =
            sportsApi.getTeamsListForLeague(sport, league).body()?.sports?.get(0)?.leagues?.get(0)
                ?.toDomain()!!
        return result
    }

    override suspend fun getTeamsList(sport: String, league: String): List<TeamModel> {
        val result = sportsApi.getTeamsListForLeague(sport, league)
            .body()?.sports?.get(0)?.leagues?.get(0)?.teams?.map { it.teamSingle.asDomainModel() }!!
        return result
    }

    override suspend fun storeTeamsInSportsDatabaseFullInfoTable(teams: List<TeamModel>, sport: String, league: String, leagueAbrv: String) {
        withContext(Dispatchers.IO) {
            sportsDataBase.getTeamsDao().addAllTeams(teams.map { it.asDbObj(sport, league, leagueAbrv) })
        }
    }


}