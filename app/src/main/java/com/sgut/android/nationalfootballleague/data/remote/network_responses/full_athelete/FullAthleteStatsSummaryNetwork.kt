package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteStatsSummaryNetwork(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("statistics")
    val statistics: List<FullAthleteStatisticNetwork> = listOf()
)