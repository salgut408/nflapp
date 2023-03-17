package com.sgut.android.nationalfootballleague.domain.domainmodels.new_article

data class ArticlesListModel(
    val header: String = "",
    val link: ArticleLinkModel? = ArticleLinkModel(),
    val articles: List<ArticleDomianModel> = listOf(),

    )
