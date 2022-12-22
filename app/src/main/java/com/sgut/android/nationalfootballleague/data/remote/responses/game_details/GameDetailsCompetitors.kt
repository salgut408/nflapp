package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsCompetitors (

  @SerializedName("id"         ) var id         : String?           = null,
  @SerializedName("uid"        ) var uid        : String?           = null,
  @SerializedName("order"      ) var order      : Int?              = null,
  @SerializedName("homeAway"   ) var isHomeOrAway   : String?           = null,
  @SerializedName("team"       ) var team       : GameDetailsTeam?             = GameDetailsTeam(),
  @SerializedName("record"     ) var record     : List<GameDetailsRecord> = listOf(),
  @SerializedName("possession" ) var possession : Boolean?          = null

)