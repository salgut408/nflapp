package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteItemNetworkX(
    @SerializedName("links")
    val links: List<FullAthleteLinkNetworkXXXXXX> = listOf(),
    @SerializedName("title")
    val title: String = ""
)