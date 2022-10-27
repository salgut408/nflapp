package com.sgut.android.nationalfootballleague.repository

import android.util.Log
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDomainModel
import com.sgut.android.nationalfootballleague.data.dtomappers.NflToTeamDomainModelMapper
import com.sgut.android.nationalfootballleague.data.remote.api.NflApi
import javax.inject.Inject

class NflRepository @Inject constructor(
    val teamDomainModelMapper: NflToTeamDomainModelMapper,
    val nflApi: NflApi,
) {
    suspend fun getNflTeams(): List<TeamDomainModel> {
        val response = nflApi.getAllNflTeams()

        if (response.isSuccessful) {
            val teamsResponse = nflApi.getAllNflTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams

            return teamDomainModelMapper.toDomainList(teamsResponse!!)
            Log.e("tag", "Response successful")
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        var result = nflApi.getAllNflTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
      //  var result = nflApi.getAllNflTeams().body()
        return teamDomainModelMapper.toDomainList(result!!)
    }
}