package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.TennisEventModel

data class Event(
    @SerializedName("date")
    val date: String = "",
    @SerializedName("endDate")
    val endDate: String = "",
    @SerializedName("groupings")
    val groupings: List<Grouping> = listOf(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("previousWinners")
    val previousWinners: List<PreviousWinner> = listOf(),
    @SerializedName("season")
    val season: SeasonXX = SeasonXX(),
    @SerializedName("shortName")
    val shortName: String = "",
    @SerializedName("status")
    val status: StatusX = StatusX(),
    @SerializedName("uid")
    val uid: String = "",
    @SerializedName("venue")
    val venue: VenueX = VenueX()
)

fun Event.asDomain(): TennisEventModel {
    return TennisEventModel(
        date = date,
        endDate = endDate,
        groupings = groupings.map { it.asDomain() },
        id = id,
        previousWinners = previousWinners.map { it.asDomain() },
        season = season.asDomain(),
        shortName = shortName,
        status = status.asDomain(),
        uid = uid,
        venue = venue.asDomain()
    )
}