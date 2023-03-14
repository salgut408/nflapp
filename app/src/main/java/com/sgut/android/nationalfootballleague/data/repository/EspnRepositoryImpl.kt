package com.sgut.android.nationalfootballleague.data.repository

import android.util.Log
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.EspnApi
import com.sgut.android.nationalfootballleague.domain.domainmodels.*
import com.sgut.android.nationalfootballleague.domain.dtomappers.NetworkGameDetailsToDomainModelMapper
import com.sgut.android.nationalfootballleague.domain.dtomappers.NetworkScoreboardToDomainModelMapper
import com.sgut.android.nationalfootballleague.domain.dtomappers.NetworkToDomainArticleMapper
import com.sgut.android.nationalfootballleague.domain.repositories.EspnRepository
import javax.inject.Inject

class EspnRepositoryImpl @Inject constructor(
    val espnApi: EspnApi,
    val sportsDataBase: SportsDataBase,
    val articleMapper: NetworkToDomainArticleMapper,
    val scoreboardDomainMapper: NetworkScoreboardToDomainModelMapper,
    val gameDetailsToDomainModelMapper: NetworkGameDetailsToDomainModelMapper,
) : EspnRepository {

    override suspend fun saveArticle(article: GameDetailModel) {
        sportsDataBase.getArticleDao().insertArticle(article.asDbArticle())
    }

//    override suspend fun getSavedArticles(): Flow<List<ArticleModel>>  {
//        val lists = sportsDataBase.getArticleDao().getAllSavedArticles()
//        return articleMapper.toDomainList(lists)
//    }





    override suspend fun getGeneralScoreboardResponse(
        sport: String,
        league: String,
    ): ScoreboardResponseEventModel {
        val response = espnApi.getGeneralScoreboard(sport, league)
        if
                (response.isSuccessful) {
            val scoreBoardresponse = espnApi.getGeneralScoreboard(sport, league).body()
            Log.e("gen board repo", "response succ $scoreBoardresponse")
            return scoreboardDomainMapper.mapToDomainModel(scoreBoardresponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())

        }
        val result = espnApi.getGeneralScoreboard(sport, league).body()
        return scoreboardDomainMapper.mapToDomainModel(result!!)
    }

    override suspend fun getYesterdayGeneralScoreboardResponse(
        sport: String,
        league: String,
        week: Int,
    ): ScoreboardResponseEventModel {
        val response = espnApi.getYesterdayGeneralScoreboard(sport, league, week)
        if
                (response.isSuccessful) {
            val scoreBoardresponse =
                espnApi.getYesterdayGeneralScoreboard(sport, league, week).body()
            Log.e("Scoreboard_Respo_yestrdy", "yesterday response  $scoreBoardresponse")
            return scoreboardDomainMapper.mapToDomainModel(scoreBoardresponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())

        }
        val result = espnApi.getYesterdayGeneralScoreboard(sport, league, week).body()
        return scoreboardDomainMapper.mapToDomainModel(result!!)
    }

    override suspend fun getArticles(sport: String, league: String): List<ArticleModel> {
        val response = espnApi.getArticles(sport, league)
        if
                (response.isSuccessful) {
            val articleResponse = espnApi.getArticles(sport, league).body()?.articles
//            Log.e("articles resp repo", "response succ $articleResponse")
            return articleMapper.toDomainList(articleResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())

        }
        val result = espnApi.getArticles(sport, league).body()?.articles
        return articleMapper.toDomainList(result!!)
    }

    override suspend fun getGameDetails(
        sport: String,
        league: String,
        event: String,
    ): GameDetailModel {
        val response = espnApi.getGameDetails(sport, league, event)
        if
                (response.isSuccessful) {
            val getGameDetailsResponse = espnApi.getGameDetails(sport, league, event).body()
            Log.e("game_details repo", "response succ $getGameDetailsResponse")
            return gameDetailsToDomainModelMapper.mapToDomainModel(getGameDetailsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())

        }
        val result = espnApi.getGameDetails(sport, league, event).body()
        return gameDetailsToDomainModelMapper.mapToDomainModel(result!!)
    }


    override suspend fun getGeneralScoreboardResponseByDate(
        sport: String,
        league: String,
        date: String,
    ): ScoreboardResponseEventModel {
        TODO("Not yet implemented")
    }

    override suspend fun getTeamSchedule(
        sport: String,
        league: String,
        teamId: Int,
    ): TeamScheduleModel {
        TODO("Not yet implemented")
    }

}