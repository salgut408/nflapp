package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.baseball


import com.google.gson.annotations.SerializedName

data class TeamXXX(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("alternateColor")
    val alternateColor: String = "",
    @SerializedName("color")
    val color: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("isActive")
    val isActive: Boolean = false,
    @SerializedName("location")
    val location: String = "",
    @SerializedName("logo")
    val logo: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = "",
    @SerializedName("uid")
    val uid: String = ""
)