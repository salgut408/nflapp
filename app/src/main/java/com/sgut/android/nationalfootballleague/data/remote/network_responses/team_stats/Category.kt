package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_stats


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_stats_models.CategoryModel

data class Category(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("stats")
    val stats: List<Stat> = listOf()
)

fun Category.asDomain(): CategoryModel {
    return CategoryModel(
        abbreviation = abbreviation,
        displayName = displayName,
        name = name,
        stats = stats.map { it.asDomain() }
    )
}