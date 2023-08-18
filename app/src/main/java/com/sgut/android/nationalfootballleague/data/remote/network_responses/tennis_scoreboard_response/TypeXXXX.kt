package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.TypeTennisModelXXXX

data class TypeXXXX(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("type")
    val type: Int = 0
)
fun TypeXXXX.asDomain(): TypeTennisModelXXXX {
    return TypeTennisModelXXXX(
        abbreviation = abbreviation,
        id = id,
        name = name,
        type = type
    )
}