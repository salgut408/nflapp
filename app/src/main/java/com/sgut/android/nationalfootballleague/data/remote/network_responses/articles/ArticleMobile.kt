package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class ArticleMobile (

  @SerializedName("leagues" )
  val leagues : ArticleLeagues? = ArticleLeagues()

)