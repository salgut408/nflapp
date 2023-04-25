package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class League(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("logos")
    val logos: List<Logo> = listOf(),
    @SerializedName("midsizeName")
    val midsizeName: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("shortName")
    val shortName: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("uid")
    val uid: String = ""
)