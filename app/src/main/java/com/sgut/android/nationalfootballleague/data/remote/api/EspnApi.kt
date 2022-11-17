package com.sgut.android.nationalfootballleague.data.remote.api

import com.sgut.android.nationalfootballleague.NFLTeamsResponse
import com.sgut.android.nationalfootballleague.TeamDetailResponse2
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EspnApi {
    @GET("sports/football/nfl/teams")
    suspend fun getAllNflTeams(): Response<NFLTeamsResponse>

    @GET("sports/football/nfl/teams/{teamAbbreviation}?enable=roster,headshot")
    suspend fun getSpecificNflTeam(
        @Path("teamAbbreviation")
        teamAbbreviation: String? = null
    ): Response<TeamDetailResponse2>


//    @GET("sports/football/college-football/teams/ucla?enable=roster,headshot")


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