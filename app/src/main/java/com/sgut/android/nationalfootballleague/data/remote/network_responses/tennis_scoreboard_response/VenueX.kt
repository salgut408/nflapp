package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.VenueTennisModelX

data class VenueX(
    @SerializedName("displayName")
    val displayName: String = ""
)

fun VenueX.asDomain(): VenueTennisModelX {
    return VenueTennisModelX(
        displayName = displayName
    )
}