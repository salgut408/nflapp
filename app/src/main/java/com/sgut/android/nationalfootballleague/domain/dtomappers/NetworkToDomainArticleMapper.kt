package com.sgut.android.nationalfootballleague.domain.dtomappers

import com.sgut.android.nationalfootballleague.Articles
import com.sgut.android.nationalfootballleague.domain.domainmodels.ArticleModel

class NetworkToDomainArticleMapper: DomainMapper<Articles, ArticleModel> {
    override fun mapToDomainModel(model: Articles): ArticleModel {
        return ArticleModel(
            byline = model.byline,
            description = model.description,
            headline = model.headline,
            images = model.images,
            published = model.published,
            type = model.type
        )


    }
    fun toDomainList(initial: List<Articles>): List<ArticleModel> {
        return initial.map { mapToDomainModel(it) }
    }
}