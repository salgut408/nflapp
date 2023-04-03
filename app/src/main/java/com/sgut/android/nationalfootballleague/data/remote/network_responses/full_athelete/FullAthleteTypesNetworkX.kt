package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteTypesNetworkX(
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("items")
    val items: List<FullAthleteItemNetworkXX> = listOf(),
    @SerializedName("pageCount")
    val pageCount: Int = 0,
    @SerializedName("pageIndex")
    val pageIndex: Int = 0,
    @SerializedName("pageSize")
    val pageSize: Int = 0
)