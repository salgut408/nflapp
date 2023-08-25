package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.basketball.wnba


import com.google.gson.annotations.SerializedName

data class Ticket(
    @SerializedName("links")
    val links: List<LinkXX> = listOf(),
    @SerializedName("numberAvailable")
    val numberAvailable: Int = 0,
    @SerializedName("summary")
    val summary: String = ""
)