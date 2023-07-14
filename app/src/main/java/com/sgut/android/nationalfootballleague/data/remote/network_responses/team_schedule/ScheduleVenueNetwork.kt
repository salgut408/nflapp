package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleVenueModel

data class ScheduleVenueNetwork(
    @SerializedName("address")
    val address: ScheduleAddressNetwork = ScheduleAddressNetwork(),
    @SerializedName("fullName")
    val fullName: String = ""
)

fun ScheduleVenueNetwork.asDomain(): ScheduleVenueModel {
    return ScheduleVenueModel(
        address = address.asDomain(),
        fullName = fullName
    )
}