package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteGroupNetwork(
    @SerializedName("groups")
    val groups: List<FullAthleteGroupNetworkX> = listOf(),
    @SerializedName("header")
    val header: String = ""
)