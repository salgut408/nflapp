package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

import com.sgut.android.nationalfootballleague.GameDetailsLink
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticleDomianModel

data class NewsModel(
    val header: String = "",
    val link: GameDetailsLink? = GameDetailsLink(),
    val articles: List<ArticleDomianModel> = listOf(), // same as ArticleDomianModel

)
