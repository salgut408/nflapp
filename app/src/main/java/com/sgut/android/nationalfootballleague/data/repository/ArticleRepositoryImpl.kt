package com.sgut.android.nationalfootballleague.data.repository

import com.sgut.android.nationalfootballleague.asDomain
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.EspnApi
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticleDomianModel
import com.sgut.android.nationalfootballleague.domain.repositories.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    val espnApi: EspnApi,
    val sportsDataBase: SportsDataBase,
) : ArticleRepository {
    override suspend fun getArticles(sport: String, league: String): List<ArticleDomianModel> {
        val articleResponse = espnApi.getArticles(sport, league)
        if (articleResponse.isSuccessful) {
            return articleResponse.body()?.articles?.map { it.asDomain() } ?: listOf()
        }
        return articleResponse.body()?.articles?.map { it.asDomain() } ?: listOf()
    }

    override suspend fun getGameArticle(sport: String, league: String): List<ArticleDomianModel> {
        TODO("Not yet implemented")
    }
}