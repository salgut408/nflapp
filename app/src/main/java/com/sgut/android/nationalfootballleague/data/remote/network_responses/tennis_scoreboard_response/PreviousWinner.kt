package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.PreviousWinnerTennisModel

data class PreviousWinner(
    @SerializedName("athletes")
    val athletes: List<AthleteXX> = listOf(),
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("headshot")
    val headshot: String = "",
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = "",
    @SerializedName("type")
    val type: TypeX = TypeX()
)


fun PreviousWinner.asDomain(): PreviousWinnerTennisModel {
    return PreviousWinnerTennisModel(
        athletes = athletes.map { it.asDomain() },
        displayName = displayName,
        headshot = headshot,
        shortDisplayName = shortDisplayName,
        type = type.asDomain()
    )
}