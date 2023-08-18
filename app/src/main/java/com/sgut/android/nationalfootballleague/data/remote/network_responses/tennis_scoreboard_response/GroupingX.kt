package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.GroupingTennisModelX

data class GroupingX(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("slug")
    val slug: String = ""
)

fun GroupingX.asDomain(): GroupingTennisModelX {
    return GroupingTennisModelX(
        displayName = displayName,
        id = id,
        slug = slug
    )
}