package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class Entry(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("link")
    val link: String = "",
    @SerializedName("logo")
    val logo: Logo = Logo(),
    @SerializedName("stats")
    val stats: List<Stat> = listOf(),
    @SerializedName("team")
    val team: String = "",
    @SerializedName("uid")
    val uid: String = ""
)