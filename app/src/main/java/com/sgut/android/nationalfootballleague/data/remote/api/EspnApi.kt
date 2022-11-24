package com.sgut.android.nationalfootballleague.data.remote.api

import com.sgut.android.nationalfootballleague.NFLTeamsResponse
import com.sgut.android.nationalfootballleague.NetworkScoreboardResponse
import com.sgut.android.nationalfootballleague.TeamDetailResponse2
import com.sgut.android.nationalfootballleague.data.domainmodels.ScoreboardResponseEventModel
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

    @GET("sports/{sport}/{league}/teams/{teamAbbreviation}?enable=roster,headshot")
    suspend fun getSpecificTeam(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
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

    @GET("sports/soccer/uefa.europa/teams")
    suspend fun getAllUefaSoccerTeams(): Response<NFLTeamsResponse>

    @GET("sports/soccer/fifa.world/teams")
    suspend fun getAllFifaSoccerTeams(): Response<NFLTeamsResponse>

    @GET("sports/soccer/mex.1/teams")
    suspend fun getAllMexicanSoccerTeams(): Response<NFLTeamsResponse>

    @GET("sports/soccer/eng.1/teams")
    suspend fun getAllEnglishSoccerTeams(): Response<NFLTeamsResponse>

    @GET("sports/soccer/esp.1/teams")
    suspend fun getAllSpanishSoccerTeams(): Response<NFLTeamsResponse>

    @GET("sports/soccer/fra.1/teams")
    suspend fun getAllFrenchSoccerTeams(): Response<NFLTeamsResponse>

    @GET("sports/soccer/fifa.world/scoreboard")
    suspend fun getWorldCupScoreboard(): Response<NetworkScoreboardResponse>





    @GET("sports/{sport}/{league}/scoreboard")
    suspend fun getGeneralScoreboard(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
    ): Response<NetworkScoreboardResponse>


    @GET("sports/{sport}/{league}/teams/{teamAbbreviation}?enable=roster,headshot")
    suspend fun getSpecifhicTeam(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
        @Path("teamAbbreviation")
        teamAbbreviation: String? = null
    ): Response<TeamDetailResponse2>


}