package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.baseball


import com.google.gson.annotations.SerializedName

data class DeviceRestrictions(
    @SerializedName("devices")
    val devices: List<String> = listOf(),
    @SerializedName("type")
    val type: String = ""
)