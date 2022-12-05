package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class ArticleImages (

  @SerializedName("name"   ) var name   : String? = null,
  @SerializedName("width"  ) var width  : Int?    = null,
  @SerializedName("id"     ) var id     : Int?    = null,
  @SerializedName("credit" ) var credit : String? = null,
  @SerializedName("type"   ) var type   : String? = null,
  @SerializedName("url"    ) var url    : String? = null,
  @SerializedName("height" ) var height : Int?    = null

)