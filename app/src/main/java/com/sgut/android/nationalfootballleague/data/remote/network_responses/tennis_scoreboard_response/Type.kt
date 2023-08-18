package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.TypeTennisModel

data class Type(
    @SerializedName("completed")
    val completed: Boolean = false,
    @SerializedName("description")
    val description: String = "",
    @SerializedName("detail")
    val detail: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("shortDetail")
    val shortDetail: String = "",
    @SerializedName("state")
    val state: String = ""
)

fun Type.asDomain(): TypeTennisModel{
    return TypeTennisModel(
        completed = completed,
        description = description,
        detail = detail,
        id = id,
        name = name,
        shortDetail = shortDetail,
        state = state
    )
}