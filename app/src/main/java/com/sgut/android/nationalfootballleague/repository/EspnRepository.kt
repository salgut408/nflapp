package com.sgut.android.nationalfootballleague.repository

import android.util.Log
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDomainModel
import com.sgut.android.nationalfootballleague.data.dtomappers.NetworkToTeamDomainModelMapper
import com.sgut.android.nationalfootballleague.data.remote.api.EspnApi
import javax.inject.Inject

class EspnRepository @Inject constructor(
    val teamDomainModelMapper: NetworkToTeamDomainModelMapper,
    val espnApi: EspnApi,
) {
    suspend fun getTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllNflTeams()

        if (response.isSuccessful) {
            val teamsResponse = espnApi.getAllNflTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.e("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        var result = espnApi.getAllNflTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    suspend fun getAllCollegeTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllCollegeTeams()
    if(response.isSuccessful){
        val teamsResponse = espnApi.getAllCollegeTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
        Log.e("tag", "Response successful")
        return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
        Log.e(javaClass.name, response.errorBody().toString())
    }
        var result = espnApi.getAllCollegeTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    suspend fun getAllBaseballTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllBaseballTeams()
        if(response.isSuccessful){
            val teamsResponse = espnApi.getAllBaseballTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.e("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        var result = espnApi.getAllBaseballTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }
}