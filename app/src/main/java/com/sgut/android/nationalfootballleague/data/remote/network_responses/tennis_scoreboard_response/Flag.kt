package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.FlagTennisModel

data class Flag(
    @SerializedName("alt")
    val alt: String = "",
    @SerializedName("href")
    val href: String = "",
    @SerializedName("rel")
    val rel: List<String> = listOf()
)
fun Flag.asDomain(): FlagTennisModel {
    return FlagTennisModel(
        alt = alt,
        href = href,
        rel = rel
    )
}