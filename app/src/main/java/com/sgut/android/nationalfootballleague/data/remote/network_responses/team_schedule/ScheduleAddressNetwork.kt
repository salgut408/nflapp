package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleAddressModel

data class ScheduleAddressNetwork(
    @SerializedName("city")
    val city: String = "",
    @SerializedName("state")
    val state: String = "",
    @SerializedName("zipCode")
    val zipCode: String = ""
)

fun ScheduleAddressNetwork.asDomain(): ScheduleAddressModel {
    return ScheduleAddressModel(
        city = city,
        state = state,
        zipCode = zipCode,
    )
}