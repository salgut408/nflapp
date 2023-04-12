package com.sgut.android.nationalfootballleague.data.remote.network_responses.standings


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models.EntryModel

data class Entry(
    @SerializedName("stats")
    val stats: List<Stat> = listOf(),
    @SerializedName("team")
    val team: Team = Team()
)

fun Entry.asDomain(): EntryModel {
    return EntryModel(
        stats = stats.map { it.asDomain() },
        team = team.asDomain()
    )
}