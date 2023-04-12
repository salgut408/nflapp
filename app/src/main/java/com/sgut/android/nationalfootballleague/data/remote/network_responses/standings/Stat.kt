package com.sgut.android.nationalfootballleague.data.remote.network_responses.standings


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models.StatModel

data class Stat(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("displayValue")
    val displayValue: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = "",
    @SerializedName("summary")
    val summary: String = "",
    @SerializedName("type")
    val type: String = "",
    @SerializedName("value")
    val value: Double = 0.0
)

fun Stat.asDomain(): StatModel {
    return StatModel(
        abbreviation = abbreviation,
        description = description,
        displayValue = displayValue,
        displayName = displayName,
        id = id,
        name = name,
        shortDisplayName = shortDisplayName,
        summary = summary,
        type = type,
        value = value
    )
}