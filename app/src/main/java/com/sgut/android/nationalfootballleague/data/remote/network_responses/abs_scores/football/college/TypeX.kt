package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.football.college


import com.google.gson.annotations.SerializedName

data class TypeX(
    @SerializedName("completed")
    val completed: Boolean = false,
    @SerializedName("description")
    val description: String = "",
    @SerializedName("detail")
    val detail: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("shortDetail")
    val shortDetail: String = "",
    @SerializedName("state")
    val state: String = ""
)