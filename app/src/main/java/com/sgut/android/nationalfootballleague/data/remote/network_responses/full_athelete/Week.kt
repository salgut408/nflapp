package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class Week(
    @SerializedName("endDate")
    val endDate: String = "",
    @SerializedName("number")
    val number: Int = 0,
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("text")
    val text: String = ""
)