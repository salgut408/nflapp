package com.sgut.android.nationalfootballleague.data.repository

import com.sgut.android.nationalfootballleague.NetworkArticleResponse
import com.sgut.android.nationalfootballleague.asDomain
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.EspnApi
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticleDomianModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticlesListModel
import com.sgut.android.nationalfootballleague.domain.repositories.ArticleRepository
import retrofit2.Response
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    val espnApi: EspnApi,
    val sportsDataBase: SportsDataBase,
) : ArticleRepository {
    override suspend fun getArticles(sport: String, league: String): ArticlesListModel {


        val articleResponse = espnApi.getArticles(sport, league)


        if (articleResponse.isSuccessful) {
            return articleResponse.body()?.asDomain() ?: ArticlesListModel()
        }
        return articleResponse.body()?.asDomain() ?: ArticlesListModel()    }

    private fun responseToRequest(response: Response<NetworkArticleResponse>): Result<List<ArticleDomianModel>> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Result.success(result.asDomain().articles)
            }
        }
        return Result.failure(Throwable())
    }

    override suspend fun getGameArticle(sport: String, league: String): List<ArticleDomianModel> {
        TODO("Not yet implemented")
    }
}