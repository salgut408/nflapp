package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("date")
    val date: String = "",
    @SerializedName("endDate")
    val endDate: String = "",
    @SerializedName("groupings")
    val groupings: List<Grouping> = listOf(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("links")
    val links: List<LinkXX> = listOf(),
    @SerializedName("name")
    val name: String = "",
    @SerializedName("previousWinners")
    val previousWinners: List<PreviousWinner> = listOf(),
    @SerializedName("season")
    val season: SeasonX = SeasonX(),
    @SerializedName("shortName")
    val shortName: String = "",
    @SerializedName("status")
    val status: StatusX = StatusX(),
    @SerializedName("uid")
    val uid: String = "",
    @SerializedName("venue")
    val venue: VenueX = VenueX()
)