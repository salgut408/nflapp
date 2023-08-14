package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName

data class Competition(
    @SerializedName("broadcasts")
    val broadcasts: List<Any> = listOf(),
    @SerializedName("competitors")
    val competitors: List<Competitor> = listOf(),
    @SerializedName("date")
    val date: String = "",
    @SerializedName("format")
    val format: Format = Format(),
    @SerializedName("geoBroadcasts")
    val geoBroadcasts: List<Any> = listOf(),
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