package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.racing


import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("city")
    val city: String = "",
    @SerializedName("country")
    val country: String = ""
)