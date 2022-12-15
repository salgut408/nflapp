package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsCompetitors (

  @SerializedName("id"         ) var id         : String?           = null,
  @SerializedName("uid"        ) var uid        : String?           = null,
  @SerializedName("order"      ) var order      : Int?              = null,
  @SerializedName("homeAway"   ) var homeAway   : String?           = null,
  @SerializedName("team"       ) var team       : Team?             = Team(),
  @SerializedName("record"     ) var record     : ArrayList<GameDetailsRecord> = arrayListOf(),
  @SerializedName("possession" ) var possession : Boolean?          = null

)