package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class ArticleMobile (

  @SerializedName("leagues" ) var leagues : ArticleLeagues? = ArticleLeagues()

)