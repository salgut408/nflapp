package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class NetworkScoreboardResponse (

  @SerializedName("leagues" ) var leagues : List<LeaguesScoreboard> = listOf(),
  @SerializedName("season"  ) var season  : SeasonScoreboard?            = SeasonScoreboard(),
  @SerializedName("day"     ) var day     : DayScoreboard?               = DayScoreboard(),
  @SerializedName("events"  ) var events  : List<EventsScoreboard>  = listOf(),
  @SerializedName("week"  ) var week  : WeekScoreboard = WeekScoreboard()



  )

data class WeekScoreboard(
  @SerializedName("number"  ) var week  : Int = 0

)