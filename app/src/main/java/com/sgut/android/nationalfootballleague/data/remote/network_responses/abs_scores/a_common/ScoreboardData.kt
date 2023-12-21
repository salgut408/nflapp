package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm.DayComm
import com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm.LeagueCommon

abstract class ScoreboardData{
     abstract val league: List<LeagueCommon>
     abstract val events: List<EventData>
     abstract val day: DayComm
}


data class DefaultScoreboardData(
     @SerializedName("leagues")
     override val league: List<LeagueCommon> = listOf(),
     @SerializedName("events")
     override val events: List<DefaultEvent> = listOf(),// default event
     @SerializedName("day")
     override val day: DayComm = DayComm()
): ScoreboardData()

data class GolfScoreboardData(
     @SerializedName("events")
     override val events: List<GolfEvent> = listOf(),// default event
     @SerializedName("leagues")
     override val league: List<LeagueCommon> = listOf(),
     @SerializedName("day")
     override val day: DayComm = DayComm()
): ScoreboardData()

data class BaseballScoreboard(
     @SerializedName("events")
     override val events: List<BaseballEvent> = listOf(), // baseball event
     @SerializedName("leagues")
     override val league: List<LeagueCommon> = listOf(),
     @SerializedName("day")
     override val day: DayComm = DayComm()
):ScoreboardData()


data class TennisScoreboard(
     @SerializedName("events")
     override val events: List<TennisEvent> = listOf(), // TennisEvent
     @SerializedName("leagues")
     override val league:  List<LeagueCommon> = listOf(),
     @SerializedName("day")
     override val day: DayComm = DayComm()
): ScoreboardData()

data class SoccerScoreboard(
     @SerializedName("events")
     override val events: List<SoccerEvent> = listOf(), // Soccer event
     @SerializedName("leagues")
     override val league:  List<LeagueCommon> = listOf(),
     @SerializedName("day")
     override val day: DayComm = DayComm()
):ScoreboardData()

data class MmaScoreboard(
     @SerializedName("events")
     override val events: List<MmaEvent> = listOf(), // MMA event
     @SerializedName("leagues")
     override val league:  List<LeagueCommon> = listOf(),
     @SerializedName("day")
     override val day: DayComm = DayComm()

):ScoreboardData()

data class RacingScoreboard(
     @SerializedName("leagues")
     override val league:  List<LeagueCommon> = listOf(),
     @SerializedName("events")
     override val events: List<RacingEvent> = listOf(), // baseball event
     @SerializedName("day")
     override val day: DayComm = DayComm()
):ScoreboardData()




