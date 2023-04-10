package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsLinks(

  @SerializedName("api")
  val api: GameDetailsApi? = GameDetailsApi(),
  @SerializedName("web")
  val web: Web? = Web(),
  @SerializedName("mobile")
  val mobile: Mobile? = Mobile(),
  @SerializedName("source")
  val source: Source2? = Source2(),
  )

data class Source2(
  @SerializedName("mezzanine")
  val mezzanine: Mezzanine? = Mezzanine(),

  )

