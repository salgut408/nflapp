package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.racing


import com.google.gson.annotations.SerializedName

data class League(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("logos")
    val logos: List<Logo> = listOf(),
    @SerializedName("name")
    val name: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("uid")
    val uid: String = ""
)