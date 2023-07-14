package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class Franchise(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("location")
    val location: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("uid")
    val uid: String = ""
)