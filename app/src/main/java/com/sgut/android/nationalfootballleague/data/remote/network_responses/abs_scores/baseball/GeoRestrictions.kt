package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.baseball


import com.google.gson.annotations.SerializedName

data class GeoRestrictions(
    @SerializedName("countries")
    val countries: List<String> = listOf(),
    @SerializedName("type")
    val type: String = ""
)