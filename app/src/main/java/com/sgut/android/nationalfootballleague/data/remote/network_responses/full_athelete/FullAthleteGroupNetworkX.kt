package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteGroupNetworkX(
    @SerializedName("standings")
    val standings: FullAthleteStandingsNetworkXXX = FullAthleteStandingsNetworkXXX()
)