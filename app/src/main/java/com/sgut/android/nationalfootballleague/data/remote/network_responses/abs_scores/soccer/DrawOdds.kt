package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.soccer


import com.google.gson.annotations.SerializedName

data class DrawOdds(
    @SerializedName("moneyLine")
    val moneyLine: Int = 0
)