package com.sgut.android.nationalfootballleague.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailModel
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDomainModel
import com.sgut.android.nationalfootballleague.data.dtomappers.NetworkToTeamDomainModelMapper
import com.sgut.android.nationalfootballleague.data.dtomappers.TeamDetailNetworkToModelMapper
import com.sgut.android.nationalfootballleague.data.remote.api.EspnApi
import javax.inject.Inject

class EspnRepository @Inject constructor(
    val teamDomainModelMapper: NetworkToTeamDomainModelMapper,
    val espnApi: EspnApi,
    val teamDetailNetworkToModelMapper: TeamDetailNetworkToModelMapper
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


    suspend fun getAllHockeyTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllHockeyTeams()
        if(response.isSuccessful){
            val teamsResponse = espnApi.getAllHockeyTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.e("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        var result = espnApi.getAllHockeyTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    suspend fun getAllBasketballTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllBasketballTeams()
        if(response.isSuccessful){
            val teamsResponse = espnApi.getAllBasketballTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.e("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        var result = espnApi.getAllBasketballTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }


    suspend fun getAllWomensBasketballTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllWomensBasketballTeams()
        if(response.isSuccessful){
            val teamsResponse = espnApi.getAllWomensBasketballTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.e("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        var result = espnApi.getAllBasketballTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    suspend fun getAllSoccerTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllSoccerTeams()
        if(response.isSuccessful){
            val teamsResponse = espnApi.getAllSoccerTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.e("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        var result = espnApi.getAllSoccerTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    suspend fun getSpecificNflTeam(): TeamDetailModel {
        val response = espnApi.getSpecificNflTeam()
        if(response.isSuccessful){
            val teamDetailResponse = espnApi.getSpecificNflTeam().body()?.team2
            Log.e("tag", "Response successful $teamDetailResponse")
            return teamDetailNetworkToModelMapper.mapToDomainModel(teamDetailResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        var result = espnApi.getSpecificNflTeam().body()?.team2
        return teamDetailNetworkToModelMapper.mapToDomainModel(result!!)
    }


}