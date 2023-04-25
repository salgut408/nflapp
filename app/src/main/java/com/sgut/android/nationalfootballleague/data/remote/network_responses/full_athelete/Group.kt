package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class Group(
    @SerializedName("groups")
    val groups: List<GroupX> = listOf(),
    @SerializedName("header")
    val header: String = ""
)