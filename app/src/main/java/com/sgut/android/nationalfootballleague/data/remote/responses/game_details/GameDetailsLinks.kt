package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsLinks (

  @SerializedName("api"    ) var api    : GameDetailsApi?    = GameDetailsApi(),
  @SerializedName("web"    ) var web    : Web?    = Web(),
  @SerializedName("mobile" ) var mobile : Mobile? = Mobile(),
  @SerializedName("source" ) var source : Source2? = Source2()


)

data class Source2(
  @SerializedName("mezzanine" ) var mezzanine : Mezzanine? = Mezzanine()

)

