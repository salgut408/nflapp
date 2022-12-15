package com.sgut.android.nationalfootballleague.data.dtomappers

import com.sgut.android.nationalfootballleague.CompetitionsScoreboard
import com.sgut.android.nationalfootballleague.EventsScoreboard
import com.sgut.android.nationalfootballleague.NetworkScoreboardResponse
import com.sgut.android.nationalfootballleague.data.domainmodels.ScoreboardResponseEventModel

class NetworkScoreboardToDomainModelMapper: DomainMapper <NetworkScoreboardResponse, ScoreboardResponseEventModel> {
    override fun mapToDomainModel(model: NetworkScoreboardResponse): ScoreboardResponseEventModel {
        return ScoreboardResponseEventModel(
        events = model.events,
            day = model.day,
            leagues = model.leagues,
            season = model.season,
            week = model.week
        )
    }

//    fun toDomainList(initial: List<EventsScoreboard>): List<ScoreboardResponseEventModel> {
//        return initial.map { mapToDomainModel(it) }
//    }

}