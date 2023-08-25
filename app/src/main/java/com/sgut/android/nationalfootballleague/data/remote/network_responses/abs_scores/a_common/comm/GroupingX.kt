package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm


import com.google.gson.annotations.SerializedName

data class GroupingX(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("slug")
    val slug: String = ""
)