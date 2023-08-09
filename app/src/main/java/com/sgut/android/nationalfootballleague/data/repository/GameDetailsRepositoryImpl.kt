package com.sgut.android.nationalfootballleague.data.repository

import android.util.Log
import com.sgut.android.nationalfootballleague.asDomain
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.SportsApi
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsModel
import com.sgut.android.nationalfootballleague.domain.repositories.GameDetailsRepository
import javax.inject.Inject
//TODO  - - Inject Dispatchers

class GameDetailsRepositoryImpl @Inject constructor(
    val sportsApi: SportsApi,
    val sportsDataBase: SportsDataBase,
):GameDetailsRepository {
    override suspend fun getGameDetails(
        sport: String,
        league: String,
        event: String,
    ): GameDetailsModel {
        val response = sportsApi.getGameDetails(sport, league, event)
        if (response.isSuccessful){
            val gameResponse = sportsApi.getGameDetails(sport, league, event).body()
            return gameResponse?.asDomain() !!
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        val result = sportsApi.getGameDetails(sport, league, event).body()
        return result?.asDomain() !!

    }

}