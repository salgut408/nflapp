//package com.sgut.android.nationalfootballleague.data.repository
//
//import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
//import com.sgut.android.nationalfootballleague.data.remote.api.EspnApi
//import com.sgut.android.nationalfootballleague.domain.domainmodels.ScoreboardResponseEventModel
//import com.sgut.android.nationalfootballleague.domain.repositories.ScoreboardRepository
//import javax.inject.Inject
//
//class ScoreboardRepositoryImpl @Inject constructor(
//    val espnApi: EspnApi,
//    val sportsDataBase: SportsDataBase,
//): ScoreboardRepository{
//
//    override suspend fun getGeneralScoreboard(
//        sport: String,
//        league: String,
//    ): ScoreboardResponseEventModel {
//        val response = espnApi.getGeneralScoreboard(sport, league)
//        if (response.isSuccessful){
////            return response.body().AsDomain
//             response.body()
//        }
//    }
//
//    override suspend fun getGeneralScoreboardByDate(
//        sport: String,
//        league: String,
//        date: String,
//    ): ScoreboardResponseEventModel {
//        TODO("Not yet implemented")
//    }
//}