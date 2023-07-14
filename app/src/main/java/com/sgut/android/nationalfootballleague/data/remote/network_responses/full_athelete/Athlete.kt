package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class Athlete(
    @SerializedName("active")
    val active: Boolean = false,
    @SerializedName("age")
    val age: Int = 0,
    @SerializedName("college")
    val college: College = College(),
    @SerializedName("debutYear")
    val debutYear: Int = 0,
    @SerializedName("displayBatsThrows")
    val displayBatsThrows: String = "",
    @SerializedName("displayBirthPlace")
    val displayBirthPlace: String = "",
    @SerializedName("displayDOB")
    val displayDOB: String = "",
    @SerializedName("displayDraft")
    val displayDraft: String = "",
    @SerializedName("displayExperience")
    val displayExperience: String = "",
    @SerializedName("displayHeight")
    val displayHeight: String = "",
    @SerializedName("displayJersey")
    val displayJersey: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("displayWeight")
    val displayWeight: String = "",
    @SerializedName("firstName")
    val firstName: String = "",
    @SerializedName("fullName")
    val fullName: String = "",
    @SerializedName("guid")
    val guid: String = "",
    @SerializedName("headshot")
    val headshot: Headshot = Headshot(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("jersey")
    val jersey: String = "",
    @SerializedName("lastName")
    val lastName: String = "",
    @SerializedName("position")
    val position: Position = Position(),
    @SerializedName("statsSummary")
    val statsSummary: StatsSummary = StatsSummary(),
    @SerializedName("status")
    val status: Status = Status(),
    @SerializedName("team")
    val team: Team = Team(),
    @SerializedName("type")
    val type: String = "",
    @SerializedName("uid")
    val uid: String = ""
)