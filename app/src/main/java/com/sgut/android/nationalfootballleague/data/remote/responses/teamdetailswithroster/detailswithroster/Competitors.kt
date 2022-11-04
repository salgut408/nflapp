package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Competitors3 (

  @SerializedName("id"       ) var id       : String? = null,
  @SerializedName("type"     ) var type     : String? = null,
  @SerializedName("order"    ) var order    : Int?    = null,
  @SerializedName("homeAway" ) var homeAway : String? = null,
  @SerializedName("team"     ) var team     : Team?   = Team()

)