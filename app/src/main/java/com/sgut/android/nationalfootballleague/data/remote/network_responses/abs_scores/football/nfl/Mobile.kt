package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.football.nfl


import com.google.gson.annotations.SerializedName

data class Mobile(
    @SerializedName("alert")
    val alert: Alert = Alert(),
    @SerializedName("href")
    val href: String = "",
    @SerializedName("progressiveDownload")
    val progressiveDownload: ProgressiveDownload = ProgressiveDownload(),
    @SerializedName("source")
    val source: Source = Source(),
    @SerializedName("streaming")
    val streaming: Streaming = Streaming()
)