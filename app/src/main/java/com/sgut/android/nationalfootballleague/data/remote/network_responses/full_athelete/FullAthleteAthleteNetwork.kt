package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

//big main
data class FullAthleteAthleteNetwork(
    @SerializedName("active")
    val active: Boolean = false,
    @SerializedName("age")
    val age: Int = 0,
    @SerializedName("college")
    val college: FullAthleteCollegeNetwork = FullAthleteCollegeNetwork(),
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
    val headshot: FullAthleteHeadshotNetwork = FullAthleteHeadshotNetwork(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("jersey")
    val jersey: String = "",
    @SerializedName("lastName")
    val lastName: String = "",
    @SerializedName("links")
    val links: List<FullAthleteLinkNetworkXX> = listOf(),
    @SerializedName("position")
    val position: FullAthletePositionNetwork = FullAthletePositionNetwork(),
    @SerializedName("statsSummary")
    val statsSummary: FullAthleteStatsSummaryNetwork = FullAthleteStatsSummaryNetwork(),
    @SerializedName("status")
    val status: FullAthleteStatusNetwork = FullAthleteStatusNetwork(),
    @SerializedName("team")
    val team: FullAthleteTeamNetwork = FullAthleteTeamNetwork(),
    @SerializedName("type")
    val type: String = "",
    @SerializedName("uid")
    val uid: String = ""
)