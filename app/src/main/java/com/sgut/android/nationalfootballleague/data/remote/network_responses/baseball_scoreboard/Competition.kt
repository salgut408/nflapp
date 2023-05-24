package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class Competition(
    @SerializedName("attendance")
    val attendance: Int? = 0,
    @SerializedName("broadcasts")
    val broadcasts: List<Broadcast>? = listOf(),
    @SerializedName("competitors")
    val competitors: List<Competitor>? = listOf(),
    @SerializedName("conferenceCompetition")
    val conferenceCompetition: Boolean? = false,
    @SerializedName("date")
    val date: String? = "",
    @SerializedName("format")
    val format: Format? = Format(),
    @SerializedName("geoBroadcasts")
    val geoBroadcasts: List<GeoBroadcast>? = listOf(),
    @SerializedName("headlines")
    val headlines: List<Headline>? = listOf(),
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("leaders")
    val leaders: List<LeaderXX>? = listOf(),
    @SerializedName("neutralSite")
    val neutralSite: Boolean? = false,
    @SerializedName("notes")
    val notes: List<Any>? = listOf(),
    @SerializedName("odds")
    val odds: List<Odd>? = listOf(),
    @SerializedName("outsText")
    val outsText: String? = "",
    @SerializedName("playByPlayAvailable")
    val playByPlayAvailable: Boolean? = false,
    @SerializedName("recent")
    val recent: Boolean? = false,
    @SerializedName("situation")
    val situation: Situation? = Situation(),
    @SerializedName("startDate")
    val startDate: String? = "",
    @SerializedName("status")
    val status: Status? = Status(),
    @SerializedName("tickets")
    val tickets: List<Ticket>? = listOf(),
    @SerializedName("timeValid")
    val timeValid: Boolean? = false,
    @SerializedName("type")
    val type: TypeXXX? = TypeXXX(),
    @SerializedName("uid")
    val uid: String? = "",
    @SerializedName("venue")
    val venue: Venue? = Venue(),
    @SerializedName("wasSuspended")
    val wasSuspended: Boolean? = false
)