package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthletePlayerSwitcherNetwork(
    @SerializedName("athletes")
    val athletes: List<FullAthleteAthletePlayerSwitcherNetwork> = listOf(),
    @SerializedName("filters")
    val filters: List<FullAthleteFilterNetwork> = listOf(),
    @SerializedName("links")
    val links: List<FullAthleteLinkNetworkXX> = listOf(),
    @SerializedName("team")
    val team: FullAthleteTeamNetworkX = FullAthleteTeamNetworkX()
)