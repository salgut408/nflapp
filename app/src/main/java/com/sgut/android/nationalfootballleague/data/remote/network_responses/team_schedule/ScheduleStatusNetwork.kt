package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleStatusModel

data class ScheduleStatusNetwork(
    @SerializedName("clock")
    val clock: Double = 0.0,
    @SerializedName("displayClock")
    val displayClock: String = "",
    @SerializedName("featuredAthletes")
    val featuredAthletes: List<ScheduleFeaturedAthleteNetwork>? = listOf(),
    @SerializedName("halfInning")
    val halfInning: Int = 0,
    @SerializedName("period")
    val period: Int = 0,
    @SerializedName("periodPrefix")
    val periodPrefix: String = "",
    @SerializedName("type")
    val type: ScheduleTypeNetwork = ScheduleTypeNetwork()
)

fun ScheduleStatusNetwork.asDomain(): ScheduleStatusModel {
    return ScheduleStatusModel(
        clock = clock,
        displayClock = displayClock,
        featuredAthletes = featuredAthletes?.map { it.asDomain() },
        halfInning = halfInning,
        period = period,
        periodPrefix = periodPrefix,
        type = type.asDomain()
    )
}