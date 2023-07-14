package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticleImageModel


data class ArticleImages(

  @SerializedName("name")
  val name: String? = null,
  @SerializedName("width")
  val width: Int? = null,
  @SerializedName("id")
  val id: Int? = null,
  @SerializedName("credit")
  val credit: String? = null,
  @SerializedName("type")
  val type: String? = null,
  @SerializedName("url")
  val url: String? = null,
  @SerializedName("height")
  val height: Int? = null,

  )

fun ArticleImages.asDomain(): ArticleImageModel {
    return ArticleImageModel(
      width = width ?: 0,
      id = id ?: 0,
      credit = credit ?: "",
      url = url ?: "",
      height = height ?: 0
    )
}