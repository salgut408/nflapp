package com.sgut.android.nationalfootballleague.domain.repositories

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticleDomianModel

interface ArticleRepository {
    suspend fun getArticles(sport: String, league: String): List<ArticleDomianModel>
    // use game details article api part
    suspend fun getGameArticle(sport: String, league: String): List<ArticleDomianModel>

}