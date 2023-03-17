package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class ArticleLinks(

  @SerializedName("api") val api: ArticleApi? = ArticleApi(),
  @SerializedName("web") val web: ArticleWeb? = ArticleWeb(),
  @SerializedName("mobile") val mobile: ArticleMobile? = ArticleMobile(),

  )