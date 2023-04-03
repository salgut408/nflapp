package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteEntryNetwork(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("link")
    val link: String = "",
    @SerializedName("logo")
    val logo: FullAthleteLogoNetwork = FullAthleteLogoNetwork(),
    @SerializedName("stats")
    val stats: List<FullAthleteStatNetwork> = listOf(),
    @SerializedName("team")
    val team: String = "",
    @SerializedName("uid")
    val uid: String = ""
)