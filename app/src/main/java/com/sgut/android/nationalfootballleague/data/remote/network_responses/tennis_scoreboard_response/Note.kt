package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.NoteTennisModel

data class Note(
    @SerializedName("text")
    val text: String = "",
    @SerializedName("type")
    val type: String = ""
)

fun Note.asDomain(): NoteTennisModel{
    return NoteTennisModel(
        text = text,
        type = type
    )
}