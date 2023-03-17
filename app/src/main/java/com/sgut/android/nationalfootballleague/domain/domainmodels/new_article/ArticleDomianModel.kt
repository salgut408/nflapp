package com.sgut.android.nationalfootballleague.domain.domainmodels.new_article

data class ArticleDomianModel(
    val images: List<ArticleImageModel> = listOf(), // needs model
    val description: String = "",
    val published: String = "",
    val headline: String = "",
    val byline: String = "",

    )
