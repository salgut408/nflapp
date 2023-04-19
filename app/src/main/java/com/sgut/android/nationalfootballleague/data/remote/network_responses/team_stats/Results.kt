package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_stats


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_stats_models.ResultsModel

data class Results(
    @SerializedName("splits")
    val splits: List<Split> = listOf(),
    @SerializedName("stats")
    val stats: Stats = Stats()
)
fun Results.asDomain(): ResultsModel {
    return ResultsModel(
        splits = splits.map { it.asDomain() },
        stats = stats.asDomain()
    )
}