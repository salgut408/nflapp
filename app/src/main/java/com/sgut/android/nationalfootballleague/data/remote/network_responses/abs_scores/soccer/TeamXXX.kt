package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.soccer


import com.google.gson.annotations.SerializedName

data class TeamXXX(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("logo")
    val logo: String = "",
    @SerializedName("uid")
    val uid: String = ""
)