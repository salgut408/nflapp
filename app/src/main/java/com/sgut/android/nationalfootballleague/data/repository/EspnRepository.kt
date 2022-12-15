package com.sgut.android.nationalfootballleague.data.repository

import android.util.Log
import com.sgut.android.nationalfootballleague.data.domainmodels.*
import com.sgut.android.nationalfootballleague.data.dtomappers.*
import com.sgut.android.nationalfootballleague.data.remote.api.EspnApi
import javax.inject.Inject

class EspnRepository @Inject constructor(
    val teamDomainModelMapper: NetworkToTeamDomainModelMapper,
    val espnApi: EspnApi,
    val articleMapper: NetworkToDomainArticleMapper,
    val teamDetailNetworkToModelMapper: TeamDetailNetworkToModelMapper,
    val rosterMapper: TeamDetailWithRosterMapper,
    val scoreboardDomainMapper: NetworkScoreboardToDomainModelMapper,
    val gameDetailsToDomainModelMapper: NetworkGameDetailsToDomainModelMapper
) {

    suspend fun getScoreboardResponse(): ScoreboardResponseEventModel {
        val response = espnApi.getWorldCupScoreboard()
        if
                (response.isSuccessful) {
            val scoreBoardresponse = espnApi.getWorldCupScoreboard().body()
//            Log.e("Scoreboard resp repo", "response succ $scoreBoardresponse")
            return scoreboardDomainMapper.mapToDomainModel(scoreBoardresponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())

        }
        val result = espnApi.getWorldCupScoreboard().body()
        return scoreboardDomainMapper.mapToDomainModel(result!!)
    }



    suspend fun getTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllNflTeams()

        if (response.isSuccessful) {
            val teamsResponse =
                espnApi.getAllNflTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.e("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        val result =
            espnApi.getAllNflTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    suspend fun getAllCollegeTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllCollegeTeams()
        if (response.isSuccessful) {
            val teamsResponse =
                espnApi.getAllCollegeTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.e("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        val result =
            espnApi.getAllCollegeTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    suspend fun getAllBaseballTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllBaseballTeams()
        if (response.isSuccessful) {
            val teamsResponse =
                espnApi.getAllBaseballTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.e("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        val result =
            espnApi.getAllBaseballTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }


    suspend fun getAllHockeyTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllHockeyTeams()
        if (response.isSuccessful) {
            val teamsResponse =
                espnApi.getAllHockeyTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.e("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        val result =
            espnApi.getAllHockeyTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    suspend fun getAllBasketballTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllBasketballTeams()
        if (response.isSuccessful) {
            val teamsResponse =
                espnApi.getAllBasketballTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.e("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        val result = espnApi.getAllBasketballTeams()
            .body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    suspend fun getAllCollegeBasketballTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllCollegeBasketballTeams()
        if (response.isSuccessful) {
            val teamsResponse =
                espnApi.getAllCollegeBasketballTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.e("fuck", teamsResponse.toString())
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        val result = espnApi.getAllCollegeBasketballTeams()
            .body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }


    suspend fun getAllWomensBasketballTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllWomensBasketballTeams()
        if (response.isSuccessful) {
            val teamsResponse =
                espnApi.getAllWomensBasketballTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.e("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        val result = espnApi.getAllBasketballTeams()
            .body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    suspend fun getAllSoccerTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllSoccerTeams()
        if (response.isSuccessful) {
            val teamsResponse =
                espnApi.getAllSoccerTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.e("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        val result =
            espnApi.getAllSoccerTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    suspend fun getAllWorldCupTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllFifaSoccerTeams()
        if (response.isSuccessful) {
            val teamsResponse =
                espnApi.getAllFifaSoccerTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.e("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        val result = espnApi.getAllFifaSoccerTeams()
            .body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    suspend fun getSpecificNflTeam(team: String): TeamDetailWithRosterModel {
        val response = espnApi.getSpecificNflTeam(team)
        if (response.isSuccessful) {
            val teamDetailResponse = espnApi.getSpecificNflTeam(team).body()?.team
            Log.e("repository spefici team", "Response successful $teamDetailResponse")
            return rosterMapper.mapToDomainModel(teamDetailResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        val result = espnApi.getSpecificNflTeam(team).body()?.team
        return rosterMapper.mapToDomainModel(result!!)
    }

    suspend fun getSpecificTeam(
        sport: String,
        league: String,
        team: String,
    ): TeamDetailWithRosterModel {
        val response = espnApi.getSpecificNflTeam(team)
        if (response.isSuccessful) {
            val teamDetailResponse = espnApi.getSpecificTeam(sport, league, team).body()?.team
            return rosterMapper.mapToDomainModel(teamDetailResponse!!)
        } else {
            Log.e("TEAM DEBUG-repo", response.errorBody().toString())
        }
        val result = espnApi.getSpecificTeam(sport, league, team).body()?.team
        return rosterMapper.mapToDomainModel(result!!)
    }

    suspend fun getGeneralScoreboardResponse(sport: String, league: String): ScoreboardResponseEventModel {
        val response = espnApi.getGeneralScoreboard(sport, league)
        if
                (response.isSuccessful) {
            val scoreBoardresponse = espnApi.getGeneralScoreboard(sport, league).body()
            Log.e("gen board repo", "response succ $scoreBoardresponse")
            return scoreboardDomainMapper.mapToDomainModel(scoreBoardresponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())

        }
        val result = espnApi.getGeneralScoreboard(sport, league).body()
        return scoreboardDomainMapper.mapToDomainModel(result!!)
    }

    suspend fun getYesterdayGeneralScoreboardResponse(sport: String, league: String, week: Int): ScoreboardResponseEventModel {
        val response = espnApi.getYesterdayGeneralScoreboard(sport, league, week)
        if
                (response.isSuccessful) {
            val scoreBoardresponse = espnApi.getYesterdayGeneralScoreboard(sport, league, week).body()
            Log.e("Scoreboard_Respo_yestrdy", "yesterday response  $scoreBoardresponse")
            return scoreboardDomainMapper.mapToDomainModel(scoreBoardresponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())

        }
        val result = espnApi.getYesterdayGeneralScoreboard(sport, league, week).body()
        return scoreboardDomainMapper.mapToDomainModel(result!!)
    }

    suspend fun getArticles(sport: String, league: String): List<ArticleModel> {
        val response = espnApi.getArticles(sport, league)
        if
                (response.isSuccessful) {
            val articleResponse = espnApi.getArticles(sport, league).body()?.articles
//            Log.e("articles resp repo", "response succ $articleResponse")
            return articleMapper.toDomainList(articleResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())

        }
        val result = espnApi.getArticles(sport, league).body()?.articles
        return articleMapper.toDomainList(result!!)
    }

    suspend fun getGameDetails(sport: String, league: String, event: String): GameDetailModel {
        val response = espnApi.getGameDetails(sport, league, event)
        if
                (response.isSuccessful) {
            val getGameDetailsResponse = espnApi.getGameDetails(sport, league, event).body()
            Log.e("game_details repo", "response succ $getGameDetailsResponse")
            return gameDetailsToDomainModelMapper.mapToDomainModel(getGameDetailsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())

        }
        val result = espnApi.getGameDetails(sport, league, event).body()
        return gameDetailsToDomainModelMapper.mapToDomainModel(result!!)
    }



}