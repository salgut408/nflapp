package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class TypeXX(
    @SerializedName("completed")
    val completed: Boolean? = false,
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("detail")
    val detail: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("shortDetail")
    val shortDetail: String? = "",
    @SerializedName("state")
    val state: String? = ""
)