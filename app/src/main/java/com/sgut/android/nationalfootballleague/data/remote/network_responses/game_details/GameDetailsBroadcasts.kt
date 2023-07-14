package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsBroadcasts (

  @SerializedName("type"   ) val type   : GameDetailsType?   = GameDetailsType(),
  @SerializedName("market" ) val market : GameDetailsMarket? = GameDetailsMarket(),
  @SerializedName("media"  ) val media  : GameDetailsMedia?  = GameDetailsMedia(),
  @SerializedName("lang"   ) val lang   : String? = null,
  @SerializedName("region" ) val region : String? = null,
  @SerializedName("station" ) val station : String? = null,



  )