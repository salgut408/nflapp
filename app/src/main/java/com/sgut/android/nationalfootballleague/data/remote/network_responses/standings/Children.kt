package com.sgut.android.nationalfootballleague.data.remote.network_responses.standings


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models.ChildrenModel

data class Children(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("shortName")
    val shortName: String = "",
    @SerializedName("standings")
    val standings: Standings = Standings(),
    @SerializedName("uid")
    val uid: String = ""
)

fun Children.asDomain(): ChildrenModel {
    return ChildrenModel(
        abbreviation = abbreviation,
        id = id,
        name = name,
        shortName = shortName,
        standings = standings.asDomain(),
        uid = uid,
    )
}