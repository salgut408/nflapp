package com.sgut.android.nationalfootballleague.data.remote.api

import com.sgut.android.nationalfootballleague.NFLTeamsResponse
import com.sgut.android.nationalfootballleague.TeamDetailResponse
import com.sgut.android.nationalfootballleague.TeamDetailResponse2
import retrofit2.Response
import retrofit2.http.GET

interface EspnApi {
    @GET("sports/football/nfl/teams")
    suspend fun getAllNflTeams(): Response<NFLTeamsResponse>

    @GET("sports/football/nfl/teams/ari?enable=roster,headshot")
    suspend fun getSpecificNflTeam(): Response<TeamDetailResponse2>

    @GET("sports/football/college-football/teams")
    suspend fun getAllCollegeTeams(): Response<NFLTeamsResponse>

    @GET("sports/baseball/mlb/teams")
    suspend fun getAllBaseballTeams(): Response<NFLTeamsResponse>

    @GET("sports/hockey/nhl/teams")
    suspend fun getAllHockeyTeams(): Response<NFLTeamsResponse>

    @GET("sports/basketball/wnba/teams")
    suspend fun getAllWomensBasketballTeams(): Response<NFLTeamsResponse>

    @GET("sports/basketball/nba/teams")
    suspend fun getAllBasketballTeams(): Response<NFLTeamsResponse>

    @GET("sports/soccer/usa.1/teams")
    suspend fun getAllSoccerTeams(): Response<NFLTeamsResponse>


}