package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.baseball


import com.google.gson.annotations.SerializedName

data class SourceX(
    @SerializedName("flash")
    val flash: Flash = Flash(),
    @SerializedName("full")
    val full: Full = Full(),
    @SerializedName("HD")
    val hD: HD = HD(),

    @SerializedName("hds")
    val hds: Hds = Hds(),
    @SerializedName("href")
    val href: String = "",
    @SerializedName("mezzanine")
    val mezzanine: Mezzanine = Mezzanine()
)