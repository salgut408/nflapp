package com.sgut.android.nationalfootballleague.data.repository

import android.util.Log
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.SportsApi
import com.sgut.android.nationalfootballleague.data.remote.network_responses.standings.asDomain
import com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models.StandingsModel
import com.sgut.android.nationalfootballleague.domain.repositories.StandingsRepository
import javax.inject.Inject
//TODO  - - Inject Dispatchers

class StandingsRepositoryImpl @Inject constructor(
    val sportsApi: SportsApi,
    val sportsDataBase: SportsDataBase,
): StandingsRepository  {
    override suspend fun getStandings(
        sport: String,
        league: String,
        type: String,
    ): StandingsModel {

        try {
            val result = sportsApi.getStandings(sport, league, type).body()
            return result?.asDomain() ?: StandingsModel("BLANK")
        } catch (e: Exception) {
            Log.e("STAND_REP", e.stackTrace.toString())
            return StandingsModel()
        }
    }
}