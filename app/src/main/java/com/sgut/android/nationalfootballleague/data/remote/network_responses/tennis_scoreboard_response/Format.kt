package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.FormatTennisModel

data class Format(
    @SerializedName("regulation")
    val regulation: Regulation = Regulation()
)

fun Format.asDomain(): FormatTennisModel{
    return FormatTennisModel(
        regulation = regulation.asDomain()
    )
}