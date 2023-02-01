package com.sgut.android.nationalfootballleague.data.domainmodels

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.*

data class ScoreboardResponseEventModel(


    val leagues: List<LeaguesScoreboard> = listOf(),
    val season: SeasonScoreboard? = SeasonScoreboard(),
    val day: DayScoreboard? = DayScoreboard(),
    val events: List<EventsScoreboard> = listOf(),
    val week: WeekScoreboard = WeekScoreboard(),


    )