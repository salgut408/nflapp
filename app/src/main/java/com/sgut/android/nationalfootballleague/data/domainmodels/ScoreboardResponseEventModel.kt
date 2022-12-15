package com.sgut.android.nationalfootballleague.data.domainmodels

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.*

data class ScoreboardResponseEventModel(


    var leagues:    List<LeaguesScoreboard>     = listOf(),
    var season:     SeasonScoreboard?      = SeasonScoreboard(),
    var day:        DayScoreboard?         = DayScoreboard(),
    var events:     List<EventsScoreboard> = listOf(),
    var week: WeekScoreboard= WeekScoreboard()


    )