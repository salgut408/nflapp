package com.sgut.android.nationalfootballleague.data.repository

import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.EspnApi
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models.FullTeamsModel
import com.sgut.android.nationalfootballleague.domain.repositories.TeamsListsRepository
import com.sgut.android.nationalfootballleague.toDomain
import javax.inject.Inject

class TeamsListRepositoryImpl @Inject constructor(
   val espnApi: EspnApi,
   val sportsDataBase: SportsDataBase
): TeamsListsRepository {
    override suspend fun getFullSportLeagueAndTeamsList(sport: String, league: String): FullTeamsModel {
        return espnApi.getTeamsListForLeague(sport, league).body()?.toDomain()!!
    }

}