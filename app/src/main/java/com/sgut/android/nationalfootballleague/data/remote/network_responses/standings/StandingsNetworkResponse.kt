package com.sgut.android.nationalfootballleague.data.remote.network_responses.standings


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models.StandingsModel

data class StandingsNetworkResponse(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("children")
    val children: List<Children> = listOf(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("links")
    val links: List<LinkXX> = listOf(),
    @SerializedName("name")
    val name: String = "",
    @SerializedName("seasons")
    val seasons: List<Season> = listOf(),
    @SerializedName("shortName")
    val shortName: String = "",
    @SerializedName("uid")
    val uid: String = ""
)

fun StandingsNetworkResponse.asDomain(): StandingsModel {
    return StandingsModel(
        abbreviation = abbreviation,
        children = children.map { it.asDomain() },
        name = name,
        id = id,
        uid = uid,
        shortName = shortName,
        seasons = seasons.map { it.asDomain() }

    )
}