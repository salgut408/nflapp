package com.sgut.android.nationalfootballleague.repository

import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDomainModel
import com.sgut.android.nationalfootballleague.data.dtomappers.NflToTeamDomainModelMapper
import com.sgut.android.nationalfootballleague.data.remote.api.NflApi
import javax.inject.Inject

class NflRepository @Inject constructor(
    val teamDomainModelMapper: NflToTeamDomainModelMapper,
    val nflApi: NflApi,
) {
    suspend fun getNflTeams(): List<TeamDomainModel> {
        var result = nflApi.getAllNflTeams().body()
        return teamDomainModelMapper.toDomainList(result!!)
    }
}