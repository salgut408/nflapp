package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class CompetitorsScoreboard (

  @SerializedName("id"         ) var id         : String?               = null,
  @SerializedName("uid"        ) var uid        : String?               = null,
  @SerializedName("type"       ) var type       : String?               = null,
  @SerializedName("order"      ) var order      : Int?                  = null,
  @SerializedName("homeAway"   ) var homeAway   : String?               = null,
  @SerializedName("winner"     ) var winner     : Boolean?              = null,
  @SerializedName("form"       ) var form       : String?               = null,
  @SerializedName("score"      ) var score      : String?               = null,
  @SerializedName("records"    ) var records    : ArrayList<RecordsScoreboard>    = arrayListOf(),
  @SerializedName("team"       ) var team       : TeamScoreboard?                 = TeamScoreboard(),
  @SerializedName("statistics" ) var statistics : ArrayList<StatisticsScoreboard> = arrayListOf()

)