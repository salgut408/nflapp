package com.sgut.android.nationalfootballleague.data.repository

import android.util.Log
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.EspnApi
import com.sgut.android.nationalfootballleague.domain.domainmodels.GameDetailModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.TeamScheduleModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.asDbArticle
import com.sgut.android.nationalfootballleague.domain.dtomappers.NetworkGameDetailsToDomainModelMapper
import com.sgut.android.nationalfootballleague.domain.repositories.EspnRepository
import javax.inject.Inject

class EspnRepositoryImpl @Inject constructor(
    val espnApi: EspnApi,
    val sportsDataBase: SportsDataBase,
    val gameDetailsToDomainModelMapper: NetworkGameDetailsToDomainModelMapper,
) : EspnRepository {

    override suspend fun saveArticle(article: GameDetailModel) {
        sportsDataBase.getArticleDao().insertArticle(article.asDbArticle())
    }

//    override suspend fun getSavedArticles(): Flow<List<ArticleModel>>  {
//        val lists = sportsDataBase.getArticleDao().getAllSavedArticles()
//        return articleMapper.toDomainList(lists)
//    }

    override suspend fun getGameDetails(
        sport: String,
        league: String,
        event: String,
    ): GameDetailModel {
        val response = espnApi.getGameDetails(sport, league, event)
        if (response.isSuccessful) {
            val getGameDetailsResponse = espnApi.getGameDetails(sport, league, event).body()
//            Log.e("game_SITUATIONSHIP", getGameDetailsResponse?.leaders .toString())
            return gameDetailsToDomainModelMapper.mapToDomainModel(getGameDetailsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())

        }
        val result = espnApi.getGameDetails(sport, league, event).body()
        return gameDetailsToDomainModelMapper.mapToDomainModel(result!!)
    }



    override suspend fun getTeamSchedule(
        sport: String,
        league: String,
        teamId: Int,
    ): TeamScheduleModel {
        TODO("Not yet implemented")
    }

}