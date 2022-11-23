package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GeoBroadcastsScoreboard (

  @SerializedName("type"   ) var type   : TypeScoreboard?   = TypeScoreboard(),
  @SerializedName("market" ) var market : MarketScoreboard? = MarketScoreboard(),
  @SerializedName("media"  ) var media  : MediaScoreboard?  = MediaScoreboard(),
  @SerializedName("lang"   ) var lang   : String? = null,
  @SerializedName("region" ) var region : String? = null

)