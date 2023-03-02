package com.sgut.android.nationalfootballleague.data.repository

import android.util.Log
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.EspnApi
import com.sgut.android.nationalfootballleague.domain.EspnRepository
import com.sgut.android.nationalfootballleague.domain.domainmodels.*
import com.sgut.android.nationalfootballleague.domain.dtomappers.*
import javax.inject.Inject

class EspnRepositoryImpl @Inject constructor(
    val teamDomainModelMapper: NetworkToTeamDomainModelMapper,
    val espnApi: EspnApi,
    val sportsDataBase: SportsDataBase,
    val articleMapper: NetworkToDomainArticleMapper,
    val teamDetailNetworkToModelMapper: TeamDetailNetworkToModelMapper,
    val rosterMapper: TeamDetailWithRosterMapper,
    val scoreboardDomainMapper: NetworkScoreboardToDomainModelMapper,
    val gameDetailsToDomainModelMapper: NetworkGameDetailsToDomainModelMapper
): EspnRepository {

    override suspend fun saveArticle(article: GameDetailModel){
        sportsDataBase.getArticleDao().insertArticle(article.asDbArticle())
        Log.d("ARTICLE_SAVED", "")
    }

//    override suspend fun getSavedArticles(): Flow<List<ArticleModel>>  {
//        val lists = sportsDataBase.getArticleDao().getAllSavedArticles()
//        return articleMapper.toDomainList(lists)
//    }



    override suspend fun getTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllNflTeams()
        if (response.isSuccessful) {
            val teamsResponse =
                espnApi.getAllNflTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.i("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.i(javaClass.name, response.errorBody().toString())
        }
        val result =
            espnApi.getAllNflTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    override suspend fun getAllCollegeTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllCollegeTeams()
        if (response.isSuccessful) {
            val teamsResponse =
                espnApi.getAllCollegeTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.i("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.i(javaClass.name, response.errorBody().toString())
        }
        val result =
            espnApi.getAllCollegeTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    override suspend fun getAllBaseballTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllBaseballTeams()
        if (response.isSuccessful) {
            val teamsResponse =
                espnApi.getAllBaseballTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.i("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.i(javaClass.name, response.errorBody().toString())
        }
        val result =
            espnApi.getAllBaseballTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    override suspend fun getAllHockeyTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllHockeyTeams()
        if (response.isSuccessful) {
            val teamsResponse =
                espnApi.getAllHockeyTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.i("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.i(javaClass.name, response.errorBody().toString())
        }
        val result =
            espnApi.getAllHockeyTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    override suspend fun getAllBasketballTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllBasketballTeams()
        if (response.isSuccessful) {
            val teamsResponse =
                espnApi.getAllBasketballTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.i("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.i(javaClass.name, response.errorBody().toString())
        }
        val result = espnApi.getAllBasketballTeams()
            .body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    override suspend fun getAllCollegeBasketballTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllCollegeBasketballTeams()
        if (response.isSuccessful) {
            val teamsResponse =
                espnApi.getAllCollegeBasketballTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.i("CollegeBskt", teamsResponse.toString())
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        val result = espnApi.getAllCollegeBasketballTeams()
            .body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    override suspend fun getAllWomensBasketballTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllWomensBasketballTeams()
        if (response.isSuccessful) {
            val teamsResponse =
                espnApi.getAllWomensBasketballTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.i("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        val result = espnApi.getAllBasketballTeams()
            .body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    override suspend fun getAllSoccerTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllSoccerTeams()
        if (response.isSuccessful) {
            val teamsResponse =
                espnApi.getAllSoccerTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.i("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        val result =
            espnApi.getAllSoccerTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    override suspend fun getAllEnglishSoccerTeams(): List<TeamDomainModel>{
        val response = espnApi.getAllEnglishSoccerTeams()
        if (response.isSuccessful){
            val teamsResponse = espnApi.getAllEnglishSoccerTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
            Log.i("EnglishTeams", teamsResponse.toString())

            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        val result = espnApi.getAllEnglishSoccerTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    override suspend fun getLaLigaSoccerTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllSpanishSoccerTeams()
        if (response.isSuccessful){
            val teamResponse = espnApi.getAllSpanishSoccerTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
            Log.d("SpanishTeams", teamResponse.toString())
            return teamDomainModelMapper.toDomainList(teamResponse!!)

        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        val result = espnApi.getAllSpanishSoccerTeams().body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    override suspend fun getAllWorldCupTeams(): List<TeamDomainModel> {
        val response = espnApi.getAllFifaSoccerTeams()
        if (response.isSuccessful) {
            val teamsResponse =
                espnApi.getAllFifaSoccerTeams().body()?.sports?.get(0)?.leagues?.get(0)?.teams
            Log.d("tag", "Response successful")
            return teamDomainModelMapper.toDomainList(teamsResponse!!)
        } else {
            Log.e(javaClass.name, response.errorBody().toString())
        }
        val result = espnApi.getAllFifaSoccerTeams()
            .body()?.sports?.getOrNull(0)?.leagues?.getOrNull(0)?.teams
        return teamDomainModelMapper.toDomainList(result!!)
    }

    override suspend fun getSpecificTeam(
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

    override suspend fun getGeneralScoreboardResponse(sport: String, league: String): ScoreboardResponseEventModel {
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

    override suspend fun getYesterdayGeneralScoreboardResponse(sport: String, league: String, week: Int): ScoreboardResponseEventModel {
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

    override suspend fun getArticles(sport: String, league: String): List<ArticleModel> {
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

    override suspend fun getGameDetails(sport: String, league: String, event: String): GameDetailModel {
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