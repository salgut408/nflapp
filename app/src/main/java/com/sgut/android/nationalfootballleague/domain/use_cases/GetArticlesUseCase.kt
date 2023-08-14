package com.sgut.android.nationalfootballleague.domain.use_cases

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticlesListModel
import com.sgut.android.nationalfootballleague.domain.repositories.ArticleRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

open class GetArticlesUseCase @Inject constructor(
    private val articleRepository: ArticleRepository,
    private val defaultDispatcher: CoroutineDispatcher,
) {
    suspend operator fun invoke(sport: String, league: String): ArticlesListModel =
        withContext(defaultDispatcher) {
            val news = articleRepository.getArticles(sport, league )
            return@withContext news
        }
}