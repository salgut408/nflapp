package com.sgut.android.nationalfootballleague.data.repository

import android.util.Log
import com.sgut.android.nationalfootballleague.asDomain
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.SportsApi
import com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard.BaseballScoreBoardNetwork
import com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response.asDomain
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.ScoreboardTennisModel
import com.sgut.android.nationalfootballleague.domain.repositories.ScoreboardRepository
import com.sgut.android.nationalfootballleague.utils.printToLog
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ScoreboardRepositoryImpl @Inject constructor(
    val sportsApi: SportsApi,
    val sportsDataBase: SportsDataBase,
    val ioDispatcher: CoroutineDispatcher,
) : ScoreboardRepository {

    override suspend fun getGeneralScoreboard(
        sport: String,
        league: String,
    ): ScoreboardModel =
        try {
            withContext(ioDispatcher) {
                val response = sportsApi.getGeneralScoreboard(sport, league)
                if (response.isSuccessful) {
                    return@withContext response.body()?.asDomain()!!
                } else {
                    Log.e("getscrboard-FAIL", response.errorBody().toString())
                    ScoreboardModel()
                }
            }
        }
        catch (e: Exception) {
            Log.e("BAD ", e.stackTraceToString())
            ScoreboardModel()

        }


    override suspend fun getCollegeBasketballScoreboard(
        sport: String,
        league: String,
        limit: String,
    ): ScoreboardModel =
        withContext(ioDispatcher) {
            val response = sportsApi.getCollegeBasketballScoreboard(sport, league, limit)
            if (response.isSuccessful) {
                return@withContext response.body()?.asDomain()!!
            } else {
                Log.e("scrbrdRepmarch-FAIL", response.errorBody().toString())
                ScoreboardModel()
            }
        }


    override suspend fun getBaseballScoreboard(
        sport: String,
        league: String,
    ): BaseballScoreBoardNetwork =

        withContext(ioDispatcher) {
            val response = sportsApi.getBaseballScoreboard(sport, league)
            if (response.isSuccessful) {
                return@withContext response.body() ?: BaseballScoreBoardNetwork()
            }
            BaseballScoreBoardNetwork()
        }

    override suspend fun getTennisScoreBoard(sport: String, league: String): ScoreboardTennisModel =
        try {
            withContext(ioDispatcher) {
                val tennis = sportsApi.getTennisScoreboard(sport, league).body()?.asDomain()!!
                tennis.printToLog("TENNIS REPO")
                return@withContext tennis
            }
        }
        catch (e: Exception) {
            Log.e("REPO-TENNIS", e.stackTraceToString())
            ScoreboardTennisModel()
        }




    override suspend fun getGeneralScoreboardByDate(
        sport: String,
        league: String,
        date: String,
    ): ScoreboardModel =
        withContext(ioDispatcher) {
            val result = sportsApi.getGeneralScoreboardWithDate(sport, league, date)
            if (result.isSuccessful) {
                return@withContext result.body()?.asDomain()!!
            } else {
                Log.e("getGeneralScoreboardByDate-FAIL", result.errorBody().toString())
                ScoreboardModel()
            }
        }
}