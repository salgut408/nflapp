package com.sgut.android.nationalfootballleague.data.remote.network_responses.standings


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models.SeasonModel

data class Season(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("endDate")
    val endDate: String = "",
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("types")
    val types: List<Type> = listOf(),
    @SerializedName("year")
    val year: Int = 0
)

fun Season.asDomain(): SeasonModel {
    return SeasonModel(
        displayName = displayName,
        endDate = endDate,
        startDate = startDate,
        types = types.map { it.asDomain() },
        year = year

    )
}