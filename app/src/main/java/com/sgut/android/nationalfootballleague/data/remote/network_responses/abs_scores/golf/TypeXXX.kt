package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.golf


import com.google.gson.annotations.SerializedName

data class TypeXXX(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("type")
    val type: Int = 0
)