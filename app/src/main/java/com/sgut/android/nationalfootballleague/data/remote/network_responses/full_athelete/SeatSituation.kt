package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class SeatSituation(
    @SerializedName("currentTeamName")
    val currentTeamName: String = "",
    @SerializedName("date")
    val date: String = "",
    @SerializedName("dateDay")
    val dateDay: String = "",
    @SerializedName("dateShort")
    val dateShort: String = "",
    @SerializedName("eventLink")
    val eventLink: String = "",
    @SerializedName("genericLink")
    val genericLink: String = "",
    @SerializedName("homeAway")
    val homeAway: String = "",
    @SerializedName("neutralSite")
    val neutralSite: Boolean = false,
    @SerializedName("opponentTeamName")
    val opponentTeamName: String = "",
    @SerializedName("summary")
    val summary: String = "",
    @SerializedName("teamLink")
    val teamLink: String = "",
    @SerializedName("venueLink")
    val venueLink: String = "",
    @SerializedName("venueName")
    val venueName: String = ""
)