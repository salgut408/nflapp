package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class StatsSummary(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("statistics")
    val statistics: List<Statistic> = listOf()
)