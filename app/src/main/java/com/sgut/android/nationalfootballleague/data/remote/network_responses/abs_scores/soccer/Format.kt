package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.soccer


import com.google.gson.annotations.SerializedName

data class Format(
    @SerializedName("regulation")
    val regulation: Regulation = Regulation()
)