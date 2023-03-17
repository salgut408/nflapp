package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName

data class News (

  @SerializedName("header"   ) var header   : String?             = null,
  @SerializedName("link"     ) var link     : GameDetailsLink?           = GameDetailsLink(),
  @SerializedName("articles" ) var articles : List<Articles> = listOf()

)



data class NetworkPlays (

  @SerializedName("id"             ) val id             : String?     = null,
  @SerializedName("sequenceNumber" ) val sequenceNumber : String?     = null,
//  @SerializedName("type"           ) val type           : Type?       = Type(),
  @SerializedName("text"           ) val text           : String?     = null,
  @SerializedName("awayScore"      ) val awayScore      : Int?        = null,
  @SerializedName("homeScore"      ) val homeScore      : Int?        = null,
  @SerializedName("period"         ) val period         : Period?     = Period(),
  @SerializedName("clock"          ) val clock          : Clock?      = Clock(),
  @SerializedName("scoringPlay"    ) val scoringPlay    : Boolean?    = null,
  @SerializedName("scoreValue"     ) val scoreValue     : Int?        = null,
  @SerializedName("team"           ) val team           : Team?       = Team(),
  @SerializedName("wallclock"      ) val wallclock      : String?     = null,
  @SerializedName("shootingPlay"   ) val shootingPlay   : Boolean?    = null,
  @SerializedName("coordinate"     ) val coordinate     : Coordinate? = Coordinate()

)


data class Coordinate (

  @SerializedName("x" ) var x : Int? = null,
  @SerializedName("y" ) var y : Int? = null

)