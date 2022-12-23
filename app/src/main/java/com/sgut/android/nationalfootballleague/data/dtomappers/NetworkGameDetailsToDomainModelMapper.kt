package com.sgut.android.nationalfootballleague.data.dtomappers

import com.sgut.android.nationalfootballleague.GameDetailResponse
import com.sgut.android.nationalfootballleague.data.domainmodels.GameDetailModel

class NetworkGameDetailsToDomainModelMapper: DomainMapper<GameDetailResponse, GameDetailModel> {
    override fun mapToDomainModel(model: GameDetailResponse): GameDetailModel {
        return GameDetailModel(
            boxscore = model.boxscore,
            broadcasts = model.broadcasts,
            format = model.format,
            gameInfo = model.gameInfo,
            header = model.header,
            injuries = model.injuries,
            lastFiveGames = model.lastFiveGames,
            leaders = model.leaders,
            news = model.news,
            odds = model.odds,
            pickcenter = model.pickcenter,
            predictor = model.predictor,
            standings = model.standings,
            ticketsInfo = model.ticketsInfo,
            drives = model.drives,
            winprobability = model.winprobability,
            scoringPlays = model.scoringPlays,
            videos = model.videos,
            singleArticle = model.singleGameArticle,

        )
    }
}