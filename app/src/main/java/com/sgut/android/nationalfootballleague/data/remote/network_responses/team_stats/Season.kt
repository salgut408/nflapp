package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_stats


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_stats_models.SeasonModel

data class Season(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("type")
    val type: Int = 0,
    @SerializedName("year")
    val year: Int = 0
)

fun Season.asDomain(): SeasonModel {
    return SeasonModel(
        displayName = displayName,
        name = name,
        type = type,
        year = year
    )
}