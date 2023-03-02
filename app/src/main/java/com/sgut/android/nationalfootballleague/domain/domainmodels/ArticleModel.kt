package com.sgut.android.nationalfootballleague.domain.domainmodels

import com.sgut.android.nationalfootballleague.ArticleImages

data class ArticleModel(
    val images: List<ArticleImages> = listOf(),
    val description: String = "",
    val published: String = "",
    val type: String = "",
    val headline: String = "",
    val byline: String = "",
    )

