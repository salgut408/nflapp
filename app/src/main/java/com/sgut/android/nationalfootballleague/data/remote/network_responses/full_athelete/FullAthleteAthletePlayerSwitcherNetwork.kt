package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteAthletePlayerSwitcherNetwork(
    @SerializedName("displayJersey")
    val displayJersey: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("guid")
    val guid: String = "",
    @SerializedName("headshot")
    val headshot: FullAthleteHeadshotNetwork = FullAthleteHeadshotNetwork(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("jersey")
    val jersey: String = "",
    @SerializedName("links")
    val links: List<FullAthleteLinkNetworkXX> = listOf(),
    @SerializedName("position")
    val position: FullAthletePositionNetworkX = FullAthletePositionNetworkX(),
    @SerializedName("uid")
    val uid: String = ""
)