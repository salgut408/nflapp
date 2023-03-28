package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName

data class ScheduleTicketNetwork(
    @SerializedName("description")
    val description: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("links")
    val links: List<ScheduleLinkNetworkX> = listOf(),
    @SerializedName("maxPrice")
    val maxPrice: Double = 0.0,
    @SerializedName("numberAvailable")
    val numberAvailable: Int = 0,
    @SerializedName("startingPrice")
    val startingPrice: Double = 0.0,
    @SerializedName("summary")
    val summary: String = "",
    @SerializedName("totalPostings")
    val totalPostings: Int = 0
)