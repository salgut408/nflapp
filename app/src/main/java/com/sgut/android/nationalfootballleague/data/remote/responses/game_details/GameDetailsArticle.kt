package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsArticle (

  @SerializedName("keywords"     ) var keywords     : List<String>     = listOf(),
  @SerializedName("description"  ) var description  : String?               = null,
  @SerializedName("source"       ) var source       : String?               = null,
  @SerializedName("video"        ) var video        : List<Video>      = listOf(),
  @SerializedName("type"         ) var type         : String?               = null,
  @SerializedName("nowId"        ) var nowId        : String?               = null,
  @SerializedName("premium"      ) var premium      : Boolean?              = null,
  @SerializedName("related"      ) var related      : List<String>     = listOf(),
  @SerializedName("allowSearch"  ) var allowSearch  : Boolean?              = null,
  @SerializedName("links"        ) var links        : Links?                = Links(),
  @SerializedName("id"           ) var id           : Int?                  = null,
  @SerializedName("categories"   ) var categories   : List<GameDetailsCategories> = listOf(),
  @SerializedName("headline"     ) var headline     : String?               = null,
  @SerializedName("gameId"       ) var gameId       : String?               = null,
  @SerializedName("images"       ) var images       : List<GameDetailsImages>     = listOf(),
  @SerializedName("linkText"     ) var linkText     : String?               = null,
  @SerializedName("published"    ) var published    : String?               = null,
  @SerializedName("guid"         ) var guid         : String?               = null,
  @SerializedName("lastModified" ) var lastModified : String?               = null,
  @SerializedName("metrics"      ) var metrics      : List<GameDetailsMetrics>    = listOf(),
//  @SerializedName("inlines"      ) var inlines      : List<String>     = listOf(),
  @SerializedName("story"        ) var story        : String?               = null

)