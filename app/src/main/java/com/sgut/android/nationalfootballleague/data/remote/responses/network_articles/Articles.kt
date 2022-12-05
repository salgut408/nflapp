package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Articles (

  @SerializedName("images"       ) var images       : List<ArticleImages>     = listOf(),
  @SerializedName("description"  ) var description  : String               = "",
  @SerializedName("published"    ) var published    : String               = "",
  @SerializedName("type"         ) var type         : String               = "",
  @SerializedName("premium"      ) var premium      : Boolean              = false,
  @SerializedName("links"        ) var links        : ArticleLinks               = ArticleLinks(),
  @SerializedName("lastModified" ) var lastModified : String            = "",
  @SerializedName("categories"   ) var categories   : List<ArticleCategories> = listOf(),
  @SerializedName("headline"     ) var headline     : String              = "",
  @SerializedName("byline"       ) var byline       : String               = "",

)