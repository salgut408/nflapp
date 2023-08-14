package com.sgut.android.nationalfootballleague.data.repository

import com.sgut.android.nationalfootballleague.asDomain
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.SportsApi
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticleDomianModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticlesListModel
import com.sgut.android.nationalfootballleague.domain.repositories.ArticleRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    val sportsApi: SportsApi,
    val sportsDataBase: SportsDataBase,
    val ioDispatcher: CoroutineDispatcher

) : ArticleRepository {
    override suspend fun getArticles(sport: String, league: String): ArticlesListModel {
        withContext(ioDispatcher) {

            val articleResponse = sportsApi.getArticles(sport, league)

            if (articleResponse.isSuccessful) {
                return@withContext articleResponse.body()?.asDomain() ?: ArticlesListModel()
            }
            return@withContext articleResponse.body()?.asDomain() ?: ArticlesListModel()
        }
        return sportsApi.getArticles(sport, league).body()?.asDomain() ?: ArticlesListModel()
    }


    override suspend fun getGameArticle(sport: String, league: String): List<ArticleDomianModel> {
        TODO("Not yet implemented")
    }
}