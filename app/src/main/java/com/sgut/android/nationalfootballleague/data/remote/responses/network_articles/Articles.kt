package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Articles (

  @SerializedName("images"       ) var images       : ArrayList<ArticleImages>     = arrayListOf(),
  @SerializedName("description"  ) var description  : String?               = null,
  @SerializedName("published"    ) var published    : String?               = null,
  @SerializedName("type"         ) var type         : String?               = null,
  @SerializedName("premium"      ) var premium      : Boolean?              = null,
  @SerializedName("links"        ) var links        : Links?                = Links(),
  @SerializedName("lastModified" ) var lastModified : String?               = null,
  @SerializedName("categories"   ) var categories   : ArrayList<ArticleCategories> = arrayListOf(),
  @SerializedName("headline"     ) var headline     : String?               = null,
  @SerializedName("byline"       ) var byline       : String?               = null

)