package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_stats


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_stats_models.SplitModel

data class Split(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("categories")
    val categories: List<Category> = listOf(),
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = ""
)
fun Split.asDomain(): SplitModel {
    return SplitModel(
        abbreviation = abbreviation,
        categories = categories.map { it.asDomain() },
        id = id,
        name = name
    )
}