package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.golf


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("stats")
    val stats: List<Stat> = listOf()
)