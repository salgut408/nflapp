package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class College(
    @SerializedName("abbrev")
    val abbrev: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("mascot")
    val mascot: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("shortName")
    val shortName: String = ""
)