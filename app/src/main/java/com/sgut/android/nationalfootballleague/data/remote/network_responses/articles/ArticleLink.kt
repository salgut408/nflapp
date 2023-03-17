package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticleLinkModel


data class ArticleLink(

  @SerializedName("language")
  val language: String? = null,
  @SerializedName("rel")
  val rel: ArrayList<String> = arrayListOf(),
  @SerializedName("href")
  val href: String? = null,
  @SerializedName("text")
  val text: String? = null,
  @SerializedName("shortText")
  val shortText: String? = null,
  @SerializedName("isExternal")
  val isExternal: Boolean? = null,
  @SerializedName("isPremium")
  val isPremium: Boolean? = null,

  )

fun ArticleLink.asDomain(): ArticleLinkModel {
  return ArticleLinkModel(
    language = language,
    rel = rel,
    href = href,
    text = text,
    shortText = shortText
  )
}