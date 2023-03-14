package com.sgut.android.nationalfootballleague.domain.repositories

import com.sgut.android.nationalfootballleague.domain.domainmodels.ArticleModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.GameDetailModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.ScoreboardResponseEventModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.TeamScheduleModel


// TODO move / break out to different repositories based on model

interface EspnRepository {
//    suspend fun getSavedArticles(): Flow<List<ArticleModel>>


    suspend fun saveArticle(article: GameDetailModel)



    suspend fun getGeneralScoreboardResponse(
        sport: String,
        league: String,
    ): ScoreboardResponseEventModel

    suspend fun getYesterdayGeneralScoreboardResponse(
        sport: String,
        league: String,
        week: Int,
    ): ScoreboardResponseEventModel

    suspend fun getArticles(sport: String, league: String): List<ArticleModel>

    suspend fun getGameDetails(sport: String, league: String, event: String): GameDetailModel

    suspend fun getGeneralScoreboardResponseByDate(
        sport: String,
        league: String,
        date: String
    ): ScoreboardResponseEventModel

    suspend fun getTeamSchedule(
        sport: String,
        league: String,
        teamId: Int
    ): TeamScheduleModel

}