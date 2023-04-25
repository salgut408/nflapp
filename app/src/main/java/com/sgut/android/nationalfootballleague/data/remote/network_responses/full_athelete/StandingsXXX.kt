package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class StandingsXXX(
    @SerializedName("entries")
    val entries: List<Entry> = listOf(),
    @SerializedName("header")
    val header: String = "",
    @SerializedName("href")
    val href: String = ""
)