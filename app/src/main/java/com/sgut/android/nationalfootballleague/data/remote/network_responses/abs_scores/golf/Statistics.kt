package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.golf


import com.google.gson.annotations.SerializedName

data class Statistics(
    @SerializedName("categories")
    val categories: List<Category> = listOf()
)