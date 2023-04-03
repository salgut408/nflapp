package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class ArticleLeague(

  @SerializedName("id")
  val id: Int = 0,
  @SerializedName("description")
  val description: String = "",
  @SerializedName("links")
  val links: ArticleLinks? = ArticleLinks(),

  )