package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticleLinkModel


data class ArticleLink(

  @SerializedName("language")
  val language: String = "",
  @SerializedName("rel")
  val rel: ArrayList<String> = arrayListOf(),
  @SerializedName("href")
  val href: String = "",
  @SerializedName("text")
  val text: String = "",
  @SerializedName("shortText")
  val shortText: String = "",
  @SerializedName("isExternal")
  val isExternal: Boolean = false,

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