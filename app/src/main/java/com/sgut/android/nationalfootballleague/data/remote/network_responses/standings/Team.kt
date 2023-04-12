package com.sgut.android.nationalfootballleague.data.remote.network_responses.standings


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models.TeamModel

data class Team(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("isActive")
    val isActive: Boolean = false,
    @SerializedName("links")
    val links: List<LinkXX> = listOf(),
    @SerializedName("location")
    val location: String = "",
    @SerializedName("logos")
    val logos: List<Logo> = listOf(),
    @SerializedName("name")
    val name: String = "",
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = "",
    @SerializedName("uid")
    val uid: String = ""
)

fun Team.asDomain(): TeamModel {
    return TeamModel(
        abbreviation = abbreviation,
        displayName = displayName,
        id = id,
        location = location,
        logos = logos.map { it.asDomain() },
        name = name,
        shortDisplayName = shortDisplayName,
        uid = uid

    )
}