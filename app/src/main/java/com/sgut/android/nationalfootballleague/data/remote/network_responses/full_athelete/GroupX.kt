package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class GroupX(
    @SerializedName("standings")
    val standings: StandingsXXX = StandingsXXX()
)