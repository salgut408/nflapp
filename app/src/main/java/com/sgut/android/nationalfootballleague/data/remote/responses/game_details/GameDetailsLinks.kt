package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsLinks (

  @SerializedName("api"    ) var api    : GameDetailsApi?    = GameDetailsApi(),
  @SerializedName("web"    ) var web    : Web?    = Web(),
  @SerializedName("mobile" ) var mobile : Mobile? = Mobile()

)