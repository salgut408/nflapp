package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.SeasonTennisModelX

data class SeasonX(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("endDate")
    val endDate: String = "",
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("type")
    val type: TypeXXXX = TypeXXXX(),
    @SerializedName("year")
    val year: Int = 0
)

fun SeasonX.asDomain(): SeasonTennisModelX{
    return SeasonTennisModelX(
        displayName = displayName,
        endDate = endDate,
        startDate = startDate,
        type = type.asDomain(),
        year = year
    )
}