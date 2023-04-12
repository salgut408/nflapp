package com.sgut.android.nationalfootballleague.data.remote.network_responses.standings


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models.LogoModel

data class Logo(
    @SerializedName("alt")
    val alt: String = "",
    @SerializedName("height")
    val height: Int = 0,
    @SerializedName("href")
    val href: String = "",
    @SerializedName("lastUpdated")
    val lastUpdated: String = "",
    @SerializedName("rel")
    val rel: List<String> = listOf(),
    @SerializedName("width")
    val width: Int = 0
)

fun Logo.asDomain(): LogoModel {
    return LogoModel(
        alt = alt,
        height = height,
        href = href,
        lastUpdated = lastUpdated,
        width = width
    )
}