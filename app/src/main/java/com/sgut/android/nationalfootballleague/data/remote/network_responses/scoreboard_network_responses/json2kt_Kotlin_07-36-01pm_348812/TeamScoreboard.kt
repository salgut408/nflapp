package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class TeamScoreboard(

    @SerializedName("id")
    val id: String = "",
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("logo")
    val logo: String = "",
    @SerializedName("color")
    val color: String = "",
    @SerializedName("displayName")
    var displayName: String = "",
    @SerializedName("score")
    val score: Int = 0,
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = "",

    )