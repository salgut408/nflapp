package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class ArticleApi(

  @SerializedName("leagues")
  val leagues: ArticleLeagues? = ArticleLeagues(),

  )