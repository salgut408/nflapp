package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class ArticleLinks (

  @SerializedName("api"    ) var api    : ArticleApi?    = ArticleApi(),
  @SerializedName("web"    ) var web    : ArticleWeb?    = ArticleWeb(),
  @SerializedName("mobile" ) var mobile : ArticleMobile? = ArticleMobile()

)