package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsBroadcasts (

  @SerializedName("type"   ) var type   : GameDetailsType?   = GameDetailsType(),
  @SerializedName("market" ) var market : GameDetailsMarket? = GameDetailsMarket(),
  @SerializedName("media"  ) var media  : GameDetailsMedia?  = GameDetailsMedia(),
  @SerializedName("lang"   ) var lang   : String? = null,
  @SerializedName("region" ) var region : String? = null

)