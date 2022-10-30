package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Links2 (

  @SerializedName("language"   ) var language   : String?           = null,
  @SerializedName("rel"        ) var rel        : List<String> = listOf(),
  @SerializedName("href"       ) var href       : String?           = null,
  @SerializedName("text"       ) var text       : String?           = null,
  @SerializedName("shortText"  ) var shortText  : String?           = null,
  @SerializedName("isExternal" ) var isExternal : Boolean?          = null,
  @SerializedName("isPremium"  ) var isPremium  : Boolean?          = null

)