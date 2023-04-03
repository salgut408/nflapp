package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteCollegeNetwork(
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