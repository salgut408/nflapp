package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class ArticleLeague (

  @SerializedName("id"          ) var id          : Int?    = null,
  @SerializedName("description" ) var description : String? = null,
  @SerializedName("links"       ) var links       : ArticleLinks?  = ArticleLinks()

)