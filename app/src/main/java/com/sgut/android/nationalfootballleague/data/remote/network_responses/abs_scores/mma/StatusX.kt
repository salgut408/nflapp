package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.mma


import com.google.gson.annotations.SerializedName

data class StatusX(
    @SerializedName("type")
    val type: TypeX = TypeX()
)