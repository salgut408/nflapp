package com.sgut.android.nationalfootballleague.domain.use_cases

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticleDomianModel
import com.sgut.android.nationalfootballleague.domain.repositories.ArticleRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

open class GetArticlesUseCase @Inject constructor(
    private val articleRepository: ArticleRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default

) {
    suspend operator fun invoke(sport: String, league: String): List<ArticleDomianModel> =
        withContext(defaultDispatcher) {
            val articles = articleRepository.getArticles(sport,league )
            return@withContext articles
        }
}