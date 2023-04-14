package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_stats


import com.google.gson.annotations.SerializedName

data class Split(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("categories")
    val categories: List<Category> = listOf(),
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = ""
)