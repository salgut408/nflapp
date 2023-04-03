package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteTeamNetworkX(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("alternateColor")
    val alternateColor: String = "",
    @SerializedName("alternateLocation")
    val alternateLocation: String = "",
    @SerializedName("color")
    val color: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("links")
    val links: List<FullAthleteLinkNetworkXX> = listOf(),
    @SerializedName("location")
    val location: String = "",
    @SerializedName("logo")
    val logo: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("uid")
    val uid: String = ""
)