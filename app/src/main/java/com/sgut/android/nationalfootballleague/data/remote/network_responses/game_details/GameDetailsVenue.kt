package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsVenue (

  @SerializedName("id"       ) var id       : String?           = null,
  @SerializedName("fullName" ) var fullName : String?           = null,
  @SerializedName("address"  ) var address  : GameDetailsAddress?          = GameDetailsAddress(),
  @SerializedName("capacity" ) var capacity : Int?              = null,
  @SerializedName("grass"    ) var grass    : Boolean?          = null,
  @SerializedName("images"   ) var images   : List<GameDetailsImages> = listOf()

)