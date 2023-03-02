package com.sgut.android.nationalfootballleague.domain

import com.sgut.android.nationalfootballleague.domain.domainmodels.*
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models.FullTeamsModel


// TODO move / break out to different repositories based on model

interface EspnRepository {
//    suspend fun getSavedArticles(): Flow<List<ArticleModel>>
    suspend fun saveArticle(article: GameDetailModel)
    suspend fun getTeams(): List<TeamDomainModel>
    suspend fun getAllCollegeTeams(): List<TeamDomainModel>
    suspend fun getAllBaseballTeams(): List<TeamDomainModel>
    suspend fun getFullTeamInfo(sport: String, league: String): FullTeamsModel
    suspend fun getAllHockeyTeams(): List<TeamDomainModel>
    suspend fun getAllBasketballTeams(): List<TeamDomainModel>
    suspend fun getAllCollegeBasketballTeams(): List<TeamDomainModel>
    suspend fun getAllWomensBasketballTeams(): List<TeamDomainModel>
    suspend fun getAllSoccerTeams(): List<TeamDomainModel>
    suspend fun getAllEnglishSoccerTeams(): List<TeamDomainModel>
    suspend fun getLaLigaSoccerTeams(): List<TeamDomainModel>
    suspend fun getAllWorldCupTeams(): List<TeamDomainModel>
    suspend fun getSpecificTeam(
        sport: String,
        league: String,
        team: String,
    ): TeamDetailWithRosterModel

    suspend fun getGeneralScoreboardResponse(
        sport: String,
        league: String,
    ): ScoreboardResponseEventModel

    suspend fun getYesterdayGeneralScoreboardResponse(
        sport: String,
        league: String,
        week: Int,
    ): ScoreboardResponseEventModel

    suspend fun storeTeamsInSportsDatabase(team: List<TeamDomainModel>)

    suspend fun getArticles(sport: String, league: String): List<ArticleModel>

    suspend fun getGameDetails(sport: String, league: String, event: String): GameDetailModel

    suspend fun getGeneralScoreboardResponseByDate(
        sport: String,
        league: String,
        date: String
    ): ScoreboardResponseEventModel

    suspend fun getTeamSchedule(
        sport: String,
        league: String,
        teamId: Int
    ): TeamScheduleModel

    suspend fun getFullSportLeagueNflTeams(): FullTeamsModel
}