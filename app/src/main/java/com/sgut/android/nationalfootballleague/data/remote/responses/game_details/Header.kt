package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Header (

  @SerializedName("id"           ) var id           : String?                 = null,
  @SerializedName("uid"          ) var uid          : String?                 = null,
  @SerializedName("season"       ) var season       : GameDetailsSeason?                 = GameDetailsSeason(),
  @SerializedName("timeValid"    ) var timeValid    : Boolean?                = null,
  @SerializedName("competitions" ) var competitions : ArrayList<GameDetailsCompetitions> = arrayListOf(),
  @SerializedName("links"        ) var links        : ArrayList<Links>        = arrayListOf(),
  @SerializedName("week"         ) var week         : Int?                    = null,
  @SerializedName("league"       ) var league       : GameDetailsLeague?                 = GameDetailsLeague()

)