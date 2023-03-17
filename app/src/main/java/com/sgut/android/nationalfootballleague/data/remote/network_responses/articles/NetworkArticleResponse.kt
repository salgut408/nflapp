package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticlesListModel


data class NetworkArticleResponse(
  @SerializedName("header")
  val header: String? = null,
  @SerializedName("link")
  val link: ArticleLink? = ArticleLink(),
  @SerializedName("articles")
  val articles: List<Articles> = listOf(),
  )

fun NetworkArticleResponse.asDomain(): ArticlesListModel {
  return ArticlesListModel(
    header = header ?: "",
    link = link?.asDomain(),
    articles = articles.map { it.asDomain() }

  )
}