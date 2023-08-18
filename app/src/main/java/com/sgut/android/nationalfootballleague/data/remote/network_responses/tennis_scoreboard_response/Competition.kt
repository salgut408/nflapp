package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.CompetitionTennisModel

data class Competition(
    @SerializedName("competitors")
    val competitors: List<Competitor> = listOf(),
    @SerializedName("date")
    val date: String = "",
    @SerializedName("format")
    val format: Format = Format(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("major")
    val major: Boolean = false,
    @SerializedName("notes")
    val notes: List<Note> = listOf(),
    @SerializedName("recent")
    val recent: Boolean = false,
    @SerializedName("round")
    val round: Round = Round(),
    @SerializedName("situation")
    val situation: Situation = Situation(),
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("status")
    val status: Status = Status(),
    @SerializedName("timeValid")
    val timeValid: Boolean = false,
    @SerializedName("tournamentId")
    val tournamentId: Int = 0,
    @SerializedName("type")
    val type: TypeX = TypeX(),
    @SerializedName("uid")
    val uid: String = "",
    @SerializedName("venue")
    val venue: Venue = Venue(),
    @SerializedName("wasSuspended")
    val wasSuspended: Boolean = false
)

fun Competition.asDomain(): CompetitionTennisModel {
    return CompetitionTennisModel(
        competitors = competitors.map { it.asDomain() },
        date = date,
        format = format.asDomain(),
        id = id,
        major = major,
        notes = notes.map { it.asDomain() },
        recent = recent,
        round = round.asDomain(),
        situation = situation.asDomain(),
        startDate = startDate,
        status = status.asDomain(),
        timeValid = timeValid,
        tournamentId = tournamentId,
        type = type.asDomain(),
        uid = uid,
        venue = venue.asDomain(),
        wasSuspended = wasSuspended,

    )
}