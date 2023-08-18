package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.CuratedRankTennisModel

data class CuratedRank(
    @SerializedName("current")
    val current: Int = 0
)
fun CuratedRank.asDomain():CuratedRankTennisModel{
    return CuratedRankTennisModel(
        current = current
    )
}