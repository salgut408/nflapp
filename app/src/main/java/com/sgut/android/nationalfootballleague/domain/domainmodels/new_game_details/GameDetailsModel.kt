package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

import com.sgut.android.nationalfootballleague.*
import com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details.Drives
import com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details.Situation
import com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details.Videos


//    TODO - Make Domain Objcts

data class GameDetailsModel(
    val situation: Situation? = Situation(),
    val notes: List<String> = listOf(),
    val boxscore: BoxScoreModel? = BoxScoreModel(),
    val format: GameDetailsFormatModel? = GameDetailsFormatModel(),
    val gameInfo: GameInfoModel? = GameInfoModel(),
    val lastFiveGames: List<LastFiveGamesModel> = listOf(),
    val leaders: List<GameDetailsLeadersModel> = listOf(),
    val injuries: List<GameDetailsInjuriesListModel> = listOf(),
    val broadcasts: List<GameDetailsBroadcasts> = listOf(), // needs mod ?  ? ?
    val predictor: PredictorModel? = PredictorModel(),
    val pickcenter: List<PickcenterModel> = listOf(),
    val againstTheSpread: List<AgainstTheSpreadModel> = listOf(),
    val odds: List<OddsModel> = listOf(),
    val header: HeaderModel? = HeaderModel(), // done - > further
    val news: NewsModel? = NewsModel(),
    val singleGameArticle: GameDetailsArticle? = GameDetailsArticle(),  // needs mod
    val ticketsInfo: GameDetailsTicketsInfo? = GameDetailsTicketsInfo(), // needs mod
    val standings: GameDetailsStandings? = GameDetailsStandings(), // needs mod
    val drives: Drives? = Drives(), // needs mod
    val winprobability: List<Winprobability> = listOf(), // needs mod
    val scoringPlays: List<ScoringPlays> = listOf(), // needs mod
    val videos: List<Videos> = listOf(),// needs mod
    val plays: List<NetworkPlays> = listOf(), // needs mod
)
