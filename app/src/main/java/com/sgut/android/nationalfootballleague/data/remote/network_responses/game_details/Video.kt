package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Video (

  @SerializedName("source"              ) var source              : String               = "",
  @SerializedName("id"                  ) var id                  : Int?                  = null,
  @SerializedName("guid"                ) var guid                : String?               = null,
  @SerializedName("headline"            ) var headline            : String?               = null,
  @SerializedName("caption"             ) var caption             : String?               = null,
  @SerializedName("description"         ) var description         : String?               = null,
  @SerializedName("premium"             ) var premium             : Boolean?              = null,
  @SerializedName("ad"                  ) var ad                  : Ad?                   = Ad(),
  @SerializedName("tracking"            ) var tracking            : Tracking?             = Tracking(),
  @SerializedName("cerebroId"           ) var cerebroId           : String?               = null,
  @SerializedName("lastModified"        ) var lastModified        : String?               = null,
  @SerializedName("originalPublishDate" ) var originalPublishDate : String?               = null,
  @SerializedName("timeRestrictions"    ) var timeRestrictions    : TimeRestrictions?     = TimeRestrictions(),
  @SerializedName("deviceRestrictions"  ) var deviceRestrictions  : DeviceRestrictions?   = DeviceRestrictions(),
  @SerializedName("syndicatable"        ) var syndicatable        : Boolean?              = null,
  @SerializedName("duration"            ) var duration            : Int?                  = null,
  @SerializedName("categories"          ) var categories          : ArrayList<GameDetailsCategories> = arrayListOf(),
  @SerializedName("keywords"            ) var keywords            : ArrayList<String>     = arrayListOf(),
  @SerializedName("posterImages"        ) var posterImages        : PosterImages?         = PosterImages(),
  @SerializedName("images"              ) var images              : ArrayList<GameDetailsImages>     = arrayListOf(),
  @SerializedName("thumbnail"           ) var thumbnail           : String?               = null,
  @SerializedName("links"               ) var links               : GameDetailsLinks?                = GameDetailsLinks(),
  @SerializedName("title"               ) var title               : String?               = null

)