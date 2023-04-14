package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_stats


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("categories")
    val categories: List<Category> = listOf(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = ""
)