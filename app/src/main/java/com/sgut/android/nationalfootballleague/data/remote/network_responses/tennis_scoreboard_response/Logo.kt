package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.LogoTennisModel

data class Logo(
    @SerializedName("alt")
    val alt: String = "",
    @SerializedName("height")
    val height: Int = 0,
    @SerializedName("href")
    val href: String = "",
    @SerializedName("lastUpdated")
    val lastUpdated: String = "",
    @SerializedName("width")
    val width: Int = 0
)

fun Logo.asDomain(): LogoTennisModel {
    return LogoTennisModel(
        alt = alt,
        height = height,
        href = href,
        lastUpdated = lastUpdated,
        width = width
    )
}