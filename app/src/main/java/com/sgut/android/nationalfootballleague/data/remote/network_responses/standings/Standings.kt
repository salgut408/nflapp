package com.sgut.android.nationalfootballleague.data.remote.network_responses.standings


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models.StandingsResponseModel

data class Standings(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("entries")
    val entries: List<Entry> = listOf(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("links")
    val links: List<LinkXX> = listOf(),
    @SerializedName("name")
    val name: String = "",
    @SerializedName("season")
    val season: Int = 0,
    @SerializedName("seasonType")
    val seasonType: Int = 0
)

fun Standings.asDomain(): StandingsResponseModel {
    return StandingsResponseModel(
        displayName = displayName,
        entries = entries.map { it.asDomain() },
        id = id,
        name = name,
        season = season,
        seasonType = seasonType,
    )
}