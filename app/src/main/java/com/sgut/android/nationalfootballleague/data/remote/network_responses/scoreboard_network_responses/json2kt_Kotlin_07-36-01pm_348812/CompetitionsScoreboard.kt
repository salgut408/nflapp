package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardCompetitionModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardFormatModel


data class CompetitionsScoreboard(

    @SerializedName("id")
    val id: String? = null,
    @SerializedName("uid")
    val uid: String? = null,
    @SerializedName("date")
    val date: String? = null,
    @SerializedName("startDate")
    val startDate: String? = null,
    @SerializedName("attendance")
    val attendance: Int? = null,
    @SerializedName("timeValid")
    val timeValid: Boolean? = null,
    @SerializedName("status")
    val status: StatusScoreboard? = StatusScoreboard(),
    @SerializedName("venue")
    val venue: VenueScoreboard = VenueScoreboard(),
    @SerializedName("format")
    val format: FormatScoreboard? = FormatScoreboard(),
    @SerializedName("geoBroadcasts")
    val geoBroadcasts: List<GeoBroadcastsScoreboard> = listOf(),
    @SerializedName("broadcasts")
    val broadcasts: List<BroadcastsScoreboard> = listOf(),
    @SerializedName("competitors")
    val competitors: List<CompetitorsScoreboard> = listOf(),
    @SerializedName("details")
    val details: List<DetailsScoreboard> = listOf(),
    @SerializedName("headlines")
    val headlines: List<HeadlinesScoreboard> = listOf(),


    )

fun CompetitionsScoreboard.asDomain(): ScoreboardCompetitionModel {
    return ScoreboardCompetitionModel(
        id = id ?: "",
        uid = uid ?: "",
        date = date ?: "",
        startDate = startDate ?: "",
        attendance = attendance ?: 0,
        status = status?.asDomain(),
        format = format?.asDomain() ?: ScoreboardFormatModel(),
        competitors = competitors.map { it.asDomain() },
        details = details.map { it.asDomain() },
        headlines = headlines.map { it.asDomain() },
        venue = venue?.asDomain()
    )
}

