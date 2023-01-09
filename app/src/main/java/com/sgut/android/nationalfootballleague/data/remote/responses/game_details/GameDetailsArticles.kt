package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsArticles (

  @SerializedName("images"       ) var images       : List<GameDetailsImages>     = listOf(),
  @SerializedName("description"  ) var description  : String?               = null,
  @SerializedName("published"    ) var published    : String?               = null,
  @SerializedName("type"         ) var type         : String?               = null,
  @SerializedName("premium"      ) var premium      : Boolean?              = null,
  @SerializedName("links"        ) var links        : GameDetailsLinks?                = GameDetailsLinks(),
  @SerializedName("lastModified" ) var lastModified : String?               = null,
  @SerializedName("categories"   ) var categories   : List<GameDetailsCategories> = listOf(),
  @SerializedName("headline"     ) var headline     : String?               = null

)