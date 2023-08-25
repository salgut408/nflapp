package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm


import com.google.gson.annotations.SerializedName

data class AddressComm(
    @SerializedName("city")
    val city: String = "",
    @SerializedName("state")
    val state: String = ""
)