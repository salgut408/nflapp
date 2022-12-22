package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName

data class News (

  @SerializedName("header"   ) var header   : String?             = null,
  @SerializedName("link"     ) var link     : GameDetailsLink?           = GameDetailsLink(),
  @SerializedName("articles" ) var articles : List<Articles> = listOf()

)