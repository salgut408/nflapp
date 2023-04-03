package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteSeasonNetworkXX(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("endDate")
    val endDate: String = "",
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("type")
    val type: FullAthleteTypeNetworkX = FullAthleteTypeNetworkX(),
    @SerializedName("types")
    val types: FullAthleteTypesNetworkX = FullAthleteTypesNetworkX(),
    @SerializedName("year")
    val year: Int = 0
)