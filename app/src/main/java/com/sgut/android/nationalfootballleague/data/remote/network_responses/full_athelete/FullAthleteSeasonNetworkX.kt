package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteSeasonNetworkX(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("endDate")
    val endDate: String = "",
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("type")
    val type: FullAthleteTypeNetwork = FullAthleteTypeNetwork(),
    @SerializedName("types")
    val types: FullAthleteTypesNetwork = FullAthleteTypesNetwork(),
    @SerializedName("year")
    val year: Int = 0
)