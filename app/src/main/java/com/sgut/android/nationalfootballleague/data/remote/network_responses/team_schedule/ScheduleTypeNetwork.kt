package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleTypeModel

data class ScheduleTypeNetwork(
    @SerializedName("completed")
    val completed: Boolean = false,
    @SerializedName("description")
    val description: String = "",
    @SerializedName("detail")
    val detail: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("shortDetail")
    val shortDetail: String = "",
    @SerializedName("state")
    val state: String = ""
)

fun ScheduleTypeNetwork.asDomain(): ScheduleTypeModel {
    return ScheduleTypeModel(
        completed = completed,
        description = description,
        detail = detail,
        id = id,
        shortDetail = shortDetail,
        state = state
    )
}