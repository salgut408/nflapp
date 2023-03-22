package com.sgut.android.nationalfootballleague.domain.domainmodels

import com.sgut.android.nationalfootballleague.*
import com.sgut.android.nationalfootballleague.data.db.article.ArticleDbObject
import com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details.*

data class GameDetailModel(

    val rosters: ArrayList<Rosters> = arrayListOf(),
    val situation: Situation? = Situation(),
    val notes: List<String> = listOf(),
    val boxscore: GameDetailsBoxscore? = GameDetailsBoxscore(),
    val format: GameDetailsFormat? = GameDetailsFormat(),
    val gameInfo: GameInfo? = GameInfo(),
    val lastFiveGames: List<LastFiveGames> = listOf(),
    val leaders: List<GameDetailsLeaders> = listOf(),
    val injuries: List<GameDetailsInjuries> = listOf(),
    val broadcasts: List<GameDetailsBroadcasts> = listOf(),
    val predictor: Predictor? = Predictor(),
    val pickcenter: List<Pickcenter> = listOf(),
    val againstTheSpread: List<AgainstTheSpread> = listOf(),
    val odds: List<Odds> = listOf(),
    val header: Header? = Header(),
    val news: News? = News(),
    val singleArticle: GameDetailsArticle? = GameDetailsArticle(),
    val ticketsInfo: GameDetailsTicketsInfo? = GameDetailsTicketsInfo(),
    val standings: GameDetailsStandings? = GameDetailsStandings(),
    val drives: Drives? = Drives(),
    val winprobability: List<Winprobability> = listOf(),
    val scoringPlays: List<ScoringPlays> = listOf(),
    val videos: List<Videos> = listOf(),
    val plays: List<NetworkPlays> = listOf(),

    )

fun GameDetailModel.asDbArticle(): ArticleDbObject {
    return ArticleDbObject(
        story = singleArticle?.story ?: "",
        headline = singleArticle?.headline ?: "",
        source = singleArticle?.source ?: "",
        description = singleArticle?.description ?: "",
        lastModified = singleArticle?.lastModified ?: "",
        published = singleArticle?.published ?: "",
    )
}
