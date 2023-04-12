package com.sgut.android.nationalfootballleague.data.repository

import android.util.Log
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.EspnApi
import com.sgut.android.nationalfootballleague.data.remote.network_responses.standings.asDomain
import com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models.StandingsModel
import com.sgut.android.nationalfootballleague.domain.repositories.StandingsRepository
import javax.inject.Inject

class StandingsRepositoryImpl @Inject constructor(
    val espnApi: EspnApi,
    val sportsDataBase: SportsDataBase,
): StandingsRepository  {
    override suspend fun getStandings(
        sport: String,
        league: String,
        type: String,
    ): StandingsModel {

        try {
            val result = espnApi.getStandings(sport, league, type).body()
            return result?.asDomain() ?: StandingsModel("BLANK")
        } catch (e: Exception) {
            Log.e("STAND_REP", e.stackTrace.toString())
            return StandingsModel()
        }
    }
}