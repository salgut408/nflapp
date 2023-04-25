package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class StandingsXX(
    @SerializedName("groups")
    val groups: List<Group> = listOf()
)