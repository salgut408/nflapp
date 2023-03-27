package com.sgut.android.nationalfootballleague.domain.repositories

import com.sgut.android.nationalfootballleague.domain.domainmodels.GameDetailModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.TeamScheduleModel


// TODO move / break out to different repositories based on model

interface EspnRepository {
//    suspend fun getSavedArticles(): Flow<List<ArticleModel>>

    suspend fun saveArticle(article: GameDetailModel)



    suspend fun getTeamSchedule(
        sport: String,
        league: String,
        teamId: Int
    ): TeamScheduleModel

}