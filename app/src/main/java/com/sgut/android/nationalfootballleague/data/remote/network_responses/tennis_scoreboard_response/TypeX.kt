package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.TypeTennisModelX

data class TypeX(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("text")
    val text: String = ""
)

fun TypeX.asDomain(): TypeTennisModelX{
    return TypeTennisModelX(
        id = id,
        slug = slug,
        text = text
    )
}