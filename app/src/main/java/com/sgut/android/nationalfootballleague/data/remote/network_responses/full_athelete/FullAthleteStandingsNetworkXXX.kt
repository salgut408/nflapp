package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteStandingsNetworkXXX(
    @SerializedName("entries")
    val entries: List<FullAthleteEntryNetwork> = listOf(),
    @SerializedName("header")
    val header: String = "",
    @SerializedName("href")
    val href: String = ""
)