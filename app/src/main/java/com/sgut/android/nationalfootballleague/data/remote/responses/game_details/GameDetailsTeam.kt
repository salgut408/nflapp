package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsTeam (

  @SerializedName("id"             ) var id             : String?          = null,
  @SerializedName("uid"            ) var uid            : String?          = null,
  @SerializedName("location"       ) var location       : String?          = null,
  @SerializedName("name"           ) var name           : String?          = null,
  @SerializedName("nickname"       ) var nickname       : String?          = null,
  @SerializedName("abbreviation"   ) var abbreviation   : String?          = null,
  @SerializedName("displayName"    ) var displayName    : String?          = null,
  @SerializedName("color"          ) var color          : String?          = null,
  @SerializedName("alternateColor" ) var alternateColor : String?          = null,
  @SerializedName("logos"          ) var logos          : List<GameDetailsLogos> = listOf(),
  @SerializedName("logo"          ) var logo          : String = "",
  @SerializedName("links"          ) var links          : List<GameDetailsLinks> = listOf(),
  @SerializedName("record"          ) var record         : List<GameDetailsRecord> = listOf(),



  )