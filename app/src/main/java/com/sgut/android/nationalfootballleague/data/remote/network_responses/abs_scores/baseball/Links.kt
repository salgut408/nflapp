package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.baseball


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("api")
    val api: Api = Api(),
    @SerializedName("mobile")
    val mobile: Mobile = Mobile(),
    @SerializedName("source")
    val source: SourceX = SourceX(),
    @SerializedName("web")
    val web: Web = Web()
)