package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteLinkNetworkXXXXXX(
    @SerializedName("attributes")
    val attributes: FullAthleteAttributesNetwork = FullAthleteAttributesNetwork(),
    @SerializedName("href")
    val href: String = "",
    @SerializedName("isExternal")
    val isExternal: Boolean = false,
    @SerializedName("isPremium")
    val isPremium: Boolean = false,
    @SerializedName("shortText")
    val shortText: String = "",
    @SerializedName("text")
    val text: String = ""
)