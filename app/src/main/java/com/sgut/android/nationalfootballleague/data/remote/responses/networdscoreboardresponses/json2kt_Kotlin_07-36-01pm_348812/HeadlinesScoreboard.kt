package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class HeadlinesScoreboard (

  @SerializedName("description"   ) var description   : String? = null,
  @SerializedName("type"          ) var type          : String? = null,
  @SerializedName("shortLinkText" ) var shortLinkText : String? = null

)