package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsArticleModel


data class GameDetailsArticle(

  @SerializedName("keywords")
  val keywords: List<String> = listOf(),
  @SerializedName("description")
  val description: String? = null,
  @SerializedName("source")
  val source: String? = null,
  @SerializedName("video")
  val video: List<Video> = listOf(),
  @SerializedName("type")
  val type: String? = null,
  @SerializedName("nowId")
  val nowId: String? = null,
  @SerializedName("premium")
  val premium: Boolean? = null,
  @SerializedName("related")
  val related: List<String> = listOf(),
  @SerializedName("allowSearch")
  val allowSearch: Boolean? = null,
  @SerializedName("links")
  val links: Links? = Links(),
  @SerializedName("id")
  val id: Int? = null,
  @SerializedName("categories")
  val categories: List<GameDetailsCategories> = listOf(),
  @SerializedName("headline")
  val headline: String? = null,
  @SerializedName("gameId")
  val gameId: String? = null,
  @SerializedName("images")
  val images: List<GameDetailsImages> = listOf(),
  @SerializedName("linkText")
  val linkText: String? = null,
  @SerializedName("published")
  val published: String? = null,
  @SerializedName("guid")
  val guid: String? = null,
  @SerializedName("lastModified")
  val lastModified: String? = null,
  @SerializedName("metrics")
  val metrics: List<GameDetailsMetrics> = listOf(),
  @SerializedName("story")
  val story: String? = null,

  )

fun GameDetailsArticle.asDomain(): GameDetailsArticleModel {
  return GameDetailsArticleModel(
    description = description ?: "",
    source = source ?: "",
    headline = headline ?: "",
    images = images,
    published = published ?: "",
    lastModified = lastModified ?: "",
    story = story ?: ""

  )
}