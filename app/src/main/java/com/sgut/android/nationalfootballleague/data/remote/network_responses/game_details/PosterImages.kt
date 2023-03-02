package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class PosterImages (

  @SerializedName("default" ) var default : Default? = Default(),
  @SerializedName("full"    ) var full    : Full?    = Full(),
  @SerializedName("wide"    ) var wide    : Wide?    = Wide(),
  @SerializedName("square"  ) var square  : Square?  = Square()

)