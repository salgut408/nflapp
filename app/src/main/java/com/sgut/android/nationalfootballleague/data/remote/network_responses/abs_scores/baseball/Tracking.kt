package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.baseball


import com.google.gson.annotations.SerializedName

data class Tracking(
    @SerializedName("coverageType")
    val coverageType: String = "",
    @SerializedName("leagueName")
    val leagueName: String = "",
    @SerializedName("sportName")
    val sportName: String = "",
    @SerializedName("trackingId")
    val trackingId: String = "",
    @SerializedName("trackingName")
    val trackingName: String = ""
)