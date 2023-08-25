package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.tennis


import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("period")
    val period: Int = 0,
    @SerializedName("type")
    val type: TypeX = TypeX()
)