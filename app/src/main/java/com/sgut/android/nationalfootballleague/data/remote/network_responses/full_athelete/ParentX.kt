package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class ParentX(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("isConference")
    val isConference: Boolean = false,
    @SerializedName("midsizeName")
    val midsizeName: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("parent")
    val parent: ParentX = ParentX(),
    @SerializedName("season")
    val season: SeasonX = SeasonX(),
    @SerializedName("shortName")
    val shortName: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("standings")
    val standings: StandingsXX = StandingsXX(),

    @SerializedName("uid")
    val uid: String = ""
)