package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsCompetitionModel


data class GameDetailsCompetitions(

    @SerializedName("id")
    val id: String? = null,
    @SerializedName("uid")
    val uid: String? = null,
    @SerializedName("date")
    val date: String? = null,
    @SerializedName("neutralSite")
    val neutralSite: Boolean? = null,
    @SerializedName("conferenceCompetition")
    val conferenceCompetition: Boolean? = null,
    @SerializedName("boxscoreAvailable")
    val boxscoreAvailable: Boolean? = null,
    @SerializedName("commentaryAvailable")
    val commentaryAvailable: Boolean? = null,
    @SerializedName("liveAvailable")
    val liveAvailable: Boolean? = null,
    @SerializedName("onWatchESPN")
    val onWatchESPN: Boolean? = null,
    @SerializedName("recent")
    val recent: Boolean? = null,
    @SerializedName("boxscoreSource")
    val boxscoreSource: String? = null,
    @SerializedName("playByPlaySource")
    val playByPlaySource: String? = null,
    @SerializedName("competitors")
    val competitors: List<GameDetailsCompetitors> = listOf(),
    @SerializedName("status")
    val status: GameDetailsStatus? = GameDetailsStatus(),
    @SerializedName("broadcasts")
    val broadcasts: ArrayList<GameDetailsBroadcasts> = arrayListOf(),
    @SerializedName("shotChartAvailable")
    val shotChartAvailable: Boolean? = null,
    @SerializedName("timeoutsAvailable")
    val timeoutsAvailable: Boolean? = null,
    @SerializedName("possessionArrowAvailable")
    val possessionArrowAvailable: Boolean? = null,


    )

fun GameDetailsCompetitions.asDomain(): GameDetailsCompetitionModel {
    return GameDetailsCompetitionModel(
        id = id ?: "",
        date = date ?: "",
        competitors = competitors.map { it.asDomain() }, // map
        status = status?.asDomain(),
        shotChartAvailable = shotChartAvailable ?: false,
        timeoutsAvailable = timeoutsAvailable ?: false,
        possessionArrowAvailable = possessionArrowAvailable ?: false

    )
}