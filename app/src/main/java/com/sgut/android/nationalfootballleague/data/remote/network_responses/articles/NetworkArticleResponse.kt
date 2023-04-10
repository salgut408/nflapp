package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticlesListModel


data class NetworkArticleResponse(
  @SerializedName("header")
  val header: String = "",
  @SerializedName("articles")
  val articles: List<Articles> = listOf(),
  )

fun NetworkArticleResponse.asDomain(): ArticlesListModel {
  return ArticlesListModel(
    header = header,
    articles = articles.map { it.asDomain() }

  )
}