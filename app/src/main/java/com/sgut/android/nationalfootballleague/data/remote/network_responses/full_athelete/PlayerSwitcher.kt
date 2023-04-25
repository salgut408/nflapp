package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class PlayerSwitcher(
    @SerializedName("athletes")
    val athletes: List<AthleteX> = listOf(),
    @SerializedName("filters")
    val filters: List<Filter> = listOf(),
    @SerializedName("links")
    val links: List<LinkXX> = listOf(),
    @SerializedName("team")
    val team: TeamX = TeamX()
)