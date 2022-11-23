package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class DetailsScoreboard (

  @SerializedName("type"             ) var type             : TypeScoreboard?                       = TypeScoreboard(),
  @SerializedName("clock"            ) var clock            : ClockScoreboard?                      = ClockScoreboard(),
  @SerializedName("team"             ) var team             : TeamScoreboard?                       = TeamScoreboard(),
  @SerializedName("scoreValue"       ) var scoreValue       : Int?                        = null,
  @SerializedName("scoringPlay"      ) var scoringPlay      : Boolean?                    = null,
  @SerializedName("redCard"          ) var redCard          : Boolean?                    = null,
  @SerializedName("yellowCard"       ) var yellowCard       : Boolean?                    = null,
  @SerializedName("penaltyKick"      ) var penaltyKick      : Boolean?                    = null,
  @SerializedName("ownGoal"          ) var ownGoal          : Boolean?                    = null,
  @SerializedName("shootout"         ) var shootout         : Boolean?                    = null,
  @SerializedName("athletesInvolved" ) var athletesInvolved : ArrayList<AthletesInvolvedScoreboard> = arrayListOf()

)