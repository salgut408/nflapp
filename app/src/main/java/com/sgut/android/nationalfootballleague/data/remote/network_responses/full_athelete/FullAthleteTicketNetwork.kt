package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteTicketNetwork(
    @SerializedName("link")
    val link: String = "",
    @SerializedName("name")
    val name: String = ""
)