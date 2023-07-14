package com.sgut.android.nationalfootballleague.data.repository

import com.sgut.android.nationalfootballleague.asDomain
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.SportsApi
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticleDomianModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticlesListModel
import com.sgut.android.nationalfootballleague.domain.repositories.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    val sportsApi: SportsApi,
    val sportsDataBase: SportsDataBase,
) : ArticleRepository {
    override suspend fun getArticles(sport: String, league: String): ArticlesListModel {
        val articleResponse = sportsApi.getArticles(sport, league)

        if (articleResponse.isSuccessful) {
            return articleResponse.body()?.asDomain() ?: ArticlesListModel()
        }
        return articleResponse.body()?.asDomain() ?: ArticlesListModel()    }

    override suspend fun getGameArticle(sport: String, league: String): List<ArticleDomianModel> {
        TODO("Not yet implemented")
    }
}