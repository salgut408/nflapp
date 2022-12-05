package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class NetworkArticleResponse (

  @SerializedName("header"   ) var header   : String?             = null,
  @SerializedName("link"     ) var link     : ArticleLink?               = ArticleLink(),
  @SerializedName("articles" ) var articles : ArrayList<Articles> = arrayListOf()

)