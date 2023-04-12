package com.sgut.android.nationalfootballleague.data.remote.network_responses.standings


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models.TypeModel

data class Type(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("endDate")
    val endDate: String = "",
    @SerializedName("hasStandings")
    val hasStandings: Boolean = false,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("startDate")
    val startDate: String = ""
)

fun Type.asDomain(): TypeModel {
    return TypeModel(
        abbreviation = abbreviation,
        endDate = endDate,
        hasStandings = hasStandings,
        id = id,
        name = name,
        startDate = startDate
    )
}