package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class AthleteX(
    @SerializedName("displayJersey")
    val displayJersey: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("guid")
    val guid: String = "",
    @SerializedName("headshot")
    val headshot: Headshot = Headshot(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("jersey")
    val jersey: String = "",
    @SerializedName("position")
    val position: PositionX = PositionX(),
    @SerializedName("uid")
    val uid: String = ""
)