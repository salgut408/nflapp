package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Broadcasts3(

  @SerializedName("type") var type: Type3? = Type3(),
  @SerializedName("market") var market: Market? = Market(),
  @SerializedName("media") var media: Media? = Media(),
  @SerializedName("lang") var lang: String? = null,
  @SerializedName("region") var region: String? = null,

  )