package com.sgut.android.nationalfootballleague.data.repository

import android.util.Log
import com.sgut.android.nationalfootballleague.asDomain
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.SportsApi
import com.sgut.android.nationalfootballleague.domain.repositories.GameDetailsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameDetailsRepositoryImpl @Inject constructor(
    val sportsApi: SportsApi,
    val sportsDataBase: SportsDataBase,
    val ioDispatcher: CoroutineDispatcher

):GameDetailsRepository {
    override suspend fun getGameDetails(
        sport: String,
        league: String,
        event: String,
    ) =
        withContext(ioDispatcher) {
            val response = sportsApi.getGameDetails(sport, league, event)
            if (response.isSuccessful){
                val gameResponse = sportsApi.getGameDetails(sport, league, event).body()
                return@withContext gameResponse?.asDomain() !!
            } else {
                Log.e(javaClass.name, response.errorBody().toString())
            }
            val result = sportsApi.getGameDetails(sport, league, event).body()
            return@withContext result?.asDomain() !!
        }
}