package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsArticle (

  @SerializedName("keywords"     ) var keywords     : ArrayList<String>     = arrayListOf(),
  @SerializedName("description"  ) var description  : String?               = null,
  @SerializedName("source"       ) var source       : String?               = null,
  @SerializedName("video"        ) var video        : ArrayList<Video>      = arrayListOf(),
  @SerializedName("type"         ) var type         : String?               = null,
  @SerializedName("nowId"        ) var nowId        : String?               = null,
  @SerializedName("premium"      ) var premium      : Boolean?              = null,
  @SerializedName("related"      ) var related      : ArrayList<String>     = arrayListOf(),
  @SerializedName("allowSearch"  ) var allowSearch  : Boolean?              = null,
  @SerializedName("links"        ) var links        : Links?                = Links(),
  @SerializedName("id"           ) var id           : Int?                  = null,
  @SerializedName("categories"   ) var categories   : ArrayList<GameDetailsCategories> = arrayListOf(),
  @SerializedName("headline"     ) var headline     : String?               = null,
  @SerializedName("gameId"       ) var gameId       : String?               = null,
  @SerializedName("images"       ) var images       : ArrayList<GameDetailsImages>     = arrayListOf(),
  @SerializedName("linkText"     ) var linkText     : String?               = null,
  @SerializedName("published"    ) var published    : String?               = null,
  @SerializedName("guid"         ) var guid         : String?               = null,
  @SerializedName("lastModified" ) var lastModified : String?               = null,
  @SerializedName("metrics"      ) var metrics      : ArrayList<GameDetailsMetrics>    = arrayListOf(),
  @SerializedName("inlines"      ) var inlines      : ArrayList<String>     = arrayListOf(),
  @SerializedName("story"        ) var story        : String?               = null

)