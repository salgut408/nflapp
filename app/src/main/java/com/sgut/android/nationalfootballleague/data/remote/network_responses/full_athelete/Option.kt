package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class Option(
    @SerializedName("displayValue")
    val displayValue: String = "",
    @SerializedName("value")
    val value: String = ""
)