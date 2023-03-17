package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticleCategoriesModel


data class ArticleCategories(

  @SerializedName("id")
  val id: Int? = null,
  @SerializedName("description")
  val description: String? = null,
  @SerializedName("type")
  val type: String? = null,
  @SerializedName("sportId")
  val sportId: Int? = null,
  @SerializedName("leagueId")
  val leagueId: Int? = null,
  @SerializedName("uid")
  val uid: String? = null,
  @SerializedName("createDate")
  val createDate: String? = null,

  )

fun ArticleCategories.asDomain(): ArticleCategoriesModel {
  return ArticleCategoriesModel(
    id = id ?: 0,
    description = description ?: "",
    sportId = sportId ?: 0,
    leagueId = leagueId ?: 0
  )
}