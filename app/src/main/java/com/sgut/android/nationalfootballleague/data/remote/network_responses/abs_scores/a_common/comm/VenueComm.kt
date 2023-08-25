package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm


import com.google.gson.annotations.SerializedName

data class VenueComm(
    @SerializedName("address")
    val address: AddressComm = AddressComm(),
    @SerializedName("capacity")
    val capacity: Int = 0,
    @SerializedName("fullName")
    val fullName: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("indoor")
    val indoor: Boolean = false
)