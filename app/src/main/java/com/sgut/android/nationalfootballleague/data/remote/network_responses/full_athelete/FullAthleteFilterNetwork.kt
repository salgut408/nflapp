package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteFilterNetwork(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("options")
    val options: List<FullAthleteOptionNetwork> = listOf(),
    @SerializedName("value")
    val value: String = ""
)