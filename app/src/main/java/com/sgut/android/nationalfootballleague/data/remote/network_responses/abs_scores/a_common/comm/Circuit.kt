package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm


import com.google.gson.annotations.SerializedName

data class Circuit(
    @SerializedName("address")
    val address: AddressComm = AddressComm(),
    @SerializedName("fullName")
    val fullName: String = "",
    @SerializedName("id")
    val id: String = ""
)