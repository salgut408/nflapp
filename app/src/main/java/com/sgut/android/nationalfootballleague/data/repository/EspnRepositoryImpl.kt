package com.sgut.android.nationalfootballleague.data.repository

import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.SportsApi
import com.sgut.android.nationalfootballleague.domain.domainmodels.GameDetailModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.asDbArticle
import com.sgut.android.nationalfootballleague.domain.repositories.EspnRepository
import javax.inject.Inject

class EspnRepositoryImpl @Inject constructor(
    val sportsApi: SportsApi,
    val sportsDataBase: SportsDataBase,
) : EspnRepository {

    override suspend fun saveArticle(article: GameDetailModel) {
        sportsDataBase.getArticleDao().insertArticle(article.asDbArticle())
    }







}