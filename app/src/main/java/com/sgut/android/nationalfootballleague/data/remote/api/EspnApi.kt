package com.sgut.android.nationalfootballleague.data.remote.api

import com.sgut.android.nationalfootballleague.*
import com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule.ScheduleResponseNetwork
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EspnApi {



    @GET("site/v2/sports/{sport}/{league}/news")
    suspend fun getArticles(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
    ): Response<NetworkArticleResponse>

    @GET("site/v2/sports/{sport}/{league}/scoreboard")
    suspend fun getGeneralScoreboard(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
    ): Response<NetworkScoreboardResponse>

    @GET("site/v2/sports/{sport}/{league}/scoreboard")
    suspend fun getCollegeBasketballScoreboard(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
        @Query("limit")
        limit: String = "500"

    ): Response<NetworkScoreboardResponse>

//    TODO adding limit takes a long time to load teams ?limit=200
    @GET("site/v2/sports/{sport}/{league}/teams")
    suspend fun getTeamsListForLeague(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
    ): Response<NFLTeamsResponse>


    @GET("site/v2/sports/{sport}/{league}/teams/{teamAbbreviation}?enable=roster,headshot")
    suspend fun getSpecificTeam(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
        @Path("teamAbbreviation")
        teamAbbreviation: String? = null
    ): Response<TeamDetailResponse2>

    @GET("site/v2/sports/{sport}/{league}/summary")
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
    @GET("site/v2/sports/{sport}/{league}/scoreboard")
    suspend fun getGeneralScoreboardWithDate(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
        @Query("dates") date: String
    ): Response<NetworkScoreboardResponse>

    @GET("site/v2/sports/{sport}/{league}/teams/{teamId}/schedule")
    suspend fun getTeamSchedule(
        @Path("sport")
        sport: String? = null,
        @Path("league")
        league: String? = null,
        @Path("teamId")
        teamId: String? = null,
    ): Response<ScheduleResponseNetwork>



//    TODO get team stats
//    https://site.api.espn.com/apis/site/v2/sports/football/nfl/teams/ari/statistics

    //    https://site.api.espn.com/apis/site/v2/sports/baseball/mlb/teams/ari/schedule


    // TODO implement racing API Endpoint F1
//    https://site.api.espn.com/apis/site/v2/sports/racing/f1/scoreboard


//    TODO add player info
//    https://site.web.api.espn.com/apis/common/v3/sports/:sport/:league_abbrev/athletes/:athlete_id

//    TODO Standings
//    https://site.api.espn.com/apis/v2/sports/baseball/mlb/standings



}