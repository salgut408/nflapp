package com.sgut.android.nationalfootballleague.domain.use_cases

import com.sgut.android.nationalfootballleague.data.db.article.ArticleDbObject
import com.sgut.android.nationalfootballleague.data.help.NetworkResult
import com.sgut.android.nationalfootballleague.data.repository.NewArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewGetArticlesUseCase @Inject constructor(
    private val newArticleRepository: NewArticleRepository,

    ) {
    operator fun invoke(
        sport: String,
        league: String,
    ): Flow<NetworkResult<Flow<List<ArticleDbObject>>>> {
        val news = newArticleRepository.getArticles(sport, league)
        return news
    }
}