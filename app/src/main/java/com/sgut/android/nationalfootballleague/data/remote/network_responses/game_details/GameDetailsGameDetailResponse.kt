package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details.Drives
import com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details.Videos
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsModel


data class GameDetailResponse(
    @SerializedName("boxscore")
    val boxscore: GameDetailsBoxscore? = GameDetailsBoxscore(),
    @SerializedName("format")
    val format: GameDetailsFormat? = GameDetailsFormat(),
    @SerializedName("gameInfo")
    val gameInfo: GameInfo? = GameInfo(),
    @SerializedName("lastFiveGames")
    val lastFiveGames: List<LastFiveGames> = listOf(),
    @SerializedName("leaders")
    val leaders: List<GameDetailsLeaders> = listOf(),
    @SerializedName("injuries")
    val injuries: List<GameDetailsInjuries> = listOf(),
    @SerializedName("broadcasts")
    val broadcasts: List<GameDetailsBroadcasts> = listOf(),
    @SerializedName("predictor")
    val predictor: Predictor? = Predictor(),
    @SerializedName("pickcenter")
    val pickcenter: List<Pickcenter> = listOf(),
    @SerializedName("againstTheSpread")
    val againstTheSpread: List<AgainstTheSpread> = listOf(),
    @SerializedName("odds")
    val odds: List<Odds> = listOf(),
    @SerializedName("header")
    val header: Header? = Header(),
    @SerializedName("news")
    val news: News? = News(),
    @SerializedName("article")
    val singleGameArticle: GameDetailsArticle? = GameDetailsArticle(),
    @SerializedName("ticketsInfo")
    val ticketsInfo: GameDetailsTicketsInfo? = GameDetailsTicketsInfo(),
    @SerializedName("standings")
    val standings: GameDetailsStandings? = GameDetailsStandings(),
    @SerializedName("drives")
    val drives: Drives? = Drives(),
    @SerializedName("plays")
    val plays: List<NetworkPlays> = listOf(),
    @SerializedName("winprobability")
    val winprobability: List<Winprobability> = listOf(),
    @SerializedName("scoringPlays")
    val scoringPlays: List<ScoringPlays> = listOf(),
    @SerializedName("videos")
    val videos: List<Videos> = listOf(),
)

fun GameDetailResponse.asDomain(): GameDetailsModel {
    return GameDetailsModel(
    boxscore = boxscore,
        format = format,
        gameInfo = gameInfo,
        lastFiveGames = lastFiveGames,
        leaders = leaders,
        injuries = injuries,
        broadcasts = broadcasts,
        predictor = predictor,
        pickcenter = pickcenter,
        againstTheSpread = againstTheSpread,
        odds = odds,
        header = header,
        news = news,
        singleGameArticle = singleGameArticle,
        ticketsInfo = ticketsInfo,
        standings = standings,
        drives = drives,
        winprobability = winprobability,
        scoringPlays = scoringPlays,
        videos = videos,
        plays = plays
    )
}

