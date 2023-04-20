package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_stats


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_stats_models.StatModel

data class Stat(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("displayValue")
    val displayValue: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = "",
    @SerializedName("value")
    val value: Double = 0.0
)

fun Stat.asDomain(): StatModel {
    return StatModel(
        abbreviation = abbreviation,
        description = description,
        displayName = displayName,
        displayValue = displayValue,
        name = name,
        shortDisplayName = shortDisplayName,
        value = value
    )
}