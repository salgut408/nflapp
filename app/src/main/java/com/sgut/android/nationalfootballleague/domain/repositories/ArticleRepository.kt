package com.sgut.android.nationalfootballleague.domain.repositories

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticleDomianModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticlesListModel

interface ArticleRepository {
    suspend fun getArticles(sport: String, league: String): ArticlesListModel
    // use game details article api part
    suspend fun getGameArticle(sport: String, league: String): List<ArticleDomianModel>

}