package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class Type(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("endDate")
    val endDate: String = "",
    @SerializedName("hasGroups")
    val hasGroups: Boolean = false,
    @SerializedName("hasLegs")
    val hasLegs: Boolean = false,
    @SerializedName("hasStandings")
    val hasStandings: Boolean = false,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("type")
    val type: Int = 0,
    @SerializedName("week")
    val week: Week = Week(),

    @SerializedName("year")
    val year: Int = 0
)