package com.sgut.android.nationalfootballleague.data.remote.api

import com.sgut.android.nationalfootballleague.*
import com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule.TeamScheduleNetworkResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EspnApi {
    @GET("v2/sports/football/nfl/teams")
    suspend fun getAllNflTeams(): Response<NFLTeamsResponse>

    @GET("v2/sports/football/nfl/teams/{teamAbbreviation}?enable=roster,headshot")
    suspend fun getSpecificNflTeam(
        @Path("teamAbbreviation")
        teamAbbreviation: String? = null
    ): Response<TeamDetailResponse2>

    @GET("v2/sports/{sport}/{league}/teams/{teamAbbreviation}?enable=roster,headshot")
    suspend fun getSpecificTeam(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
        @Path("teamAbbreviation")
        teamAbbreviation: String? = null
    ): Response<TeamDetailResponse2>

    @GET("v2/sports/football/college-football/teams")
    suspend fun getAllCollegeTeams(): Response<NFLTeamsResponse>

    @GET("v2/sports/baseball/mlb/teams")
    suspend fun getAllBaseballTeams(): Response<NFLTeamsResponse>

    @GET("v2/sports/hockey/nhl/teams")
    suspend fun getAllHockeyTeams(): Response<NFLTeamsResponse>

    @GET("v2/sports/basketball/wnba/teams")
    suspend fun getAllWomensBasketballTeams(): Response<NFLTeamsResponse>

    @GET("v2/sports/basketball/nba/teams")
    suspend fun getAllBasketballTeams(): Response<NFLTeamsResponse>

    @GET("v2/sports/soccer/usa.1/teams")
    suspend fun getAllSoccerTeams(): Response<NFLTeamsResponse>

    @GET("v2/sports/soccer/uefa.europa/teams")
    suspend fun getAllUefaSoccerTeams(): Response<NFLTeamsResponse>

    @GET("v2/sports/soccer/fifa.world/teams")
    suspend fun getAllFifaSoccerTeams(): Response<NFLTeamsResponse>

    @GET("v2/sports/basketball/mens-college-basketball/teams")
    suspend fun getAllCollegeBasketballTeams(): Response<NFLTeamsResponse>

    @GET("v2/sports/soccer/eng.1/teams")
    suspend fun getAllEnglishSoccerTeams(): Response<NFLTeamsResponse>

    @GET("v2/sports/soccer/esp.1/teams")
    suspend fun getAllSpanishSoccerTeams(): Response<NFLTeamsResponse>

    @GET("v2/sports/football/nfl/scoreboard")
    suspend fun getWorldCupScoreboard(): Response<NetworkScoreboardResponse>

    @GET("v2/sports/{sport}/{league}/news")
    suspend fun getArticles(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
    ): Response<NetworkArticleResponse>

    @GET("v2/sports/{sport}/{league}/scoreboard")
    suspend fun getGeneralScoreboard(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
    ): Response<NetworkScoreboardResponse>

    @GET("v2/sports/{sport}/{league}/scoreboard")
    suspend fun getYesterdayGeneralScoreboard(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
        @Query("week") week: Int
    ): Response<NetworkScoreboardResponse>

    @GET("v2/sports/{sport}/{league}/teams")
    suspend fun getTeamsListForLeague(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
    ): Response<NFLTeamsResponse>

    //teams ?


    @GET("v2/sports/{sport}/{league}/teams/{teamAbbreviation}?enable=roster,headshot")
    suspend fun getSpecifcTeam(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
        @Path("teamAbbreviation")
        teamAbbreviation: String? = null
    ): Response<TeamDetailResponse2>

    @GET("v2/sports/{sport}/{league}/summary")
    suspend fun getGameDetails(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
        @Query("event") event: String
    ): Response<GameDetailResponse>

    @GET("{articleApi}")
    suspend fun getArticleDetail(
        @Path("articleApi")
        articleApi: String? = null
    ): Response<ArticleDetailNetworkResponse>

// TODO implement getting scoreboard with dates
    @GET("v2/sports/{sport}/{league}/scoreboard")
    suspend fun getGeneralScoreboardWithDate(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
        @Query("dates") date: String
    ): Response<NetworkScoreboardResponse>

// TODO implement team Schedule
    @GET("v2/sports/{sport}/{league}/teams/{teamId}schedule")
    suspend fun getTeamSchedule(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
        @Path("teamId")
        teamId: Int? = null,
    ): Response<TeamScheduleNetworkResponse>


    // TODO implement racing API Endpoint F1
//    https://site.api.espn.com/apis/site/v2/sports/racing/f1/scoreboard

    // TODO add STATS
//    https://site.api.espn.com/apis/site/v2/sports/soccer/eng.1/statistics


}