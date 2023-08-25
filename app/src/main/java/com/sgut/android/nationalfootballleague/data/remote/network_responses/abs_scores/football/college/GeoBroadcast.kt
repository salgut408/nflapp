package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.football.college


import com.google.gson.annotations.SerializedName

data class GeoBroadcast(
    @SerializedName("lang")
    val lang: String = "",
    @SerializedName("market")
    val market: Market = Market(),
    @SerializedName("media")
    val media: Media = Media(),
    @SerializedName("region")
    val region: String = "",
    @SerializedName("type")
    val type: Type = Type()
)