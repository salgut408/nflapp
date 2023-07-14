package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class Quicklink(
    @SerializedName("items")
    val items: List<ItemX> = listOf(),
    @SerializedName("text")
    val text: String = "",
    @SerializedName("title")
    val title: String = ""
)