package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.mma


import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("address")
    val address: Address = Address(),
    @SerializedName("fullName")
    val fullName: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("indoor")
    val indoor: Boolean = false
)