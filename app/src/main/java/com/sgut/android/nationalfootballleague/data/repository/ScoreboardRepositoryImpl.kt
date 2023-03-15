package com.sgut.android.nationalfootballleague.data.repository

import android.util.Log
import com.sgut.android.nationalfootballleague.asDomain
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.EspnApi
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardModel
import com.sgut.android.nationalfootballleague.domain.repositories.ScoreboardRepository
import javax.inject.Inject

class ScoreboardRepositoryImpl @Inject constructor(
    val espnApi: EspnApi,
    val sportsDataBase: SportsDataBase,
): ScoreboardRepository{

//    TODO handle null check / try's better '
    override suspend fun getGeneralScoreboard(
        sport: String,
        league: String,
    ): ScoreboardModel {
        val response = espnApi.getGeneralScoreboard(sport, league)
        if (response.isSuccessful){
            Log.e("scrbrdRepo-SUCC", "response succ ${response.body()}")
            return response.body()?.asDomain()!!
        } else {
            Log.e("scrbrdRepo-FAIL", response.errorBody().toString())
        }
        val result = espnApi.getGeneralScoreboard(sport, league)
    return result.body()?.asDomain()!!
    }

    override suspend fun getGeneralScoreboardByDate(
        sport: String,
        league: String,
        date: String,
    ): ScoreboardModel {
        TODO("Not yet implemented")
    }
}