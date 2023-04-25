package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class Filter(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("options")
    val options: List<Option> = listOf(),
    @SerializedName("value")
    val value: String = ""
)