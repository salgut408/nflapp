package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class SeatSituation (

  @SerializedName("opponentTeamName" ) var opponentTeamName : String? = null,
  @SerializedName("currentTeamName"  ) var currentTeamName  : String? = null,
  @SerializedName("venueName"        ) var venueName        : String? = null,
  @SerializedName("summary"          ) var summary          : String? = null,
  @SerializedName("date"             ) var date             : String? = null,
  @SerializedName("dateShort"        ) var dateShort        : String? = null,
  @SerializedName("dateDay"          ) var dateDay          : String? = null,
  @SerializedName("homeAway"         ) var homeAway         : String? = null,
  @SerializedName("eventLink"        ) var eventLink        : String? = null,
  @SerializedName("venueLink"        ) var venueLink        : String? = null,
  @SerializedName("genericLink"      ) var genericLink      : String? = null,
  @SerializedName("teamLink"         ) var teamLink         : String? = null

)