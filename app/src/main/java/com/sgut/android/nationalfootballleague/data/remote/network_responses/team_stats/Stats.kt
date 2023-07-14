package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_stats


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_stats_models.StatsModel

data class Stats(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("categories")
    val categories: List<Category> = listOf(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = ""
)

fun Stats.asDomain(): StatsModel {
    return StatsModel(
        abbreviation = abbreviation,
        categories = categories.map { it.asDomain() },
        id = id,
        name = name
    )
}